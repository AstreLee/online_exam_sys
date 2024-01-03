package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TeacherPaperMapper;
import com.xin.online_exam_sys.pojo.request.teacher.TPaperAddQuestionQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.teacher.TPaperAddQuestionTableResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TSelectOptionResVO;
import com.xin.online_exam_sys.service.teacher.TPaperService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2024/1/2 - 10:22
 * @file : TeacherPaperServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class TPaperServiceImpl implements TPaperService {
    @Autowired
    private TeacherPaperMapper teacherPaperMapper;

    @Override
    public List<TSelectOptionResVO> getCourseOptions() {
        Long tId = JWTContextUtil.getCurrentId();
        return teacherPaperMapper.selectCourseOptions(tId);
    }

    @Override
    public Map<String, Object> getQuestionList(TPaperAddQuestionQueryInfoReqVO reqVO) {
        List<TPaperAddQuestionTableResVO> result = teacherPaperMapper.selectQuestions(reqVO.getQuestionId(),
                reqVO.getCourseId(), reqVO.getQuestionType());
        Integer pageNum = reqVO.getPageNum();
        Integer pageSize = reqVO.getPageSize();
        List<TPaperAddQuestionTableResVO> newResult = new PaginationUtil<TPaperAddQuestionTableResVO>().getLimitCount(pageNum, pageSize, result);
        for (int i = 0; i < newResult.size(); i++) {
            if (reqVO.getQuestionType() == 1 || reqVO.getQuestionType() == 2) {
                char prefix = 'A';
                for (int j = 0; j < newResult.get(i).getItems().size(); j++, prefix++) {
                    newResult.get(i).getItems().get(j).setPrefix(prefix);
                }
            }
        }
        Map<String, Object> res = new HashMap<>();
        res.put("list", newResult);
        res.put("total", newResult.size());
        return res;
    }
}
