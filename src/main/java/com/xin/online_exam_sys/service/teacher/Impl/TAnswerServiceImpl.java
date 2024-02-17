package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TAnswerMapper;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerListResVO;
import com.xin.online_exam_sys.service.teacher.TAnswerService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TAnswerServiceImpl implements TAnswerService  {
    @Autowired
    private TAnswerMapper tAnswerMapper;

    @Override
    public Map<String, Object> getStuIdsByTeacherId(TAnswerQueryInfoReqVO vo) {
        Long courseId = vo.getCourseId();
        Integer state = vo.getState();
        Integer pageNum = vo.getPageNum();
        Integer pageSize = vo.getPageSize();
        // 获取所有可能提交答卷的学生id集合
        Long tId = JWTContextUtil.getCurrentId();
        List<Long> stuIds = tAnswerMapper.selectStuIdsByTeacherId(tId);
        // 获取所有答卷
        List<TAnswerListResVO> result = tAnswerMapper.selectRecordListByIds(stuIds, courseId, state);
        List<TAnswerListResVO> newResult = new PaginationUtil<TAnswerListResVO>().getLimitCount(pageNum, pageSize, result);
        if (newResult == null) {
            Map<String, Object> res = new HashMap<>();
            res.put("list", null);
            res.put("total", 0);
            return res;
        }
        Map<String, Object> res = new HashMap<>();
        res.put("list", newResult);
        res.put("total", newResult.size());
        return res;
    }
}
