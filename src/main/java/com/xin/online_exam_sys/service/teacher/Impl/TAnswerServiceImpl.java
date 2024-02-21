package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TAnswerMapper;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerCheckInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerInfoResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerListResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerQuestionItemResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerTitleItemResVO;
import com.xin.online_exam_sys.service.teacher.TAnswerService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TAnswerServiceImpl implements TAnswerService  {
    @Autowired
    private TAnswerMapper tAnswerMapper;
    // 数据成员titleMap
    private Map<Integer, String> titleMap = new HashMap<>();
    // 代码块初始化
    {
        titleMap.put(1, "单选题");
        titleMap.put(2, "多选题");
        titleMap.put(3, "判断题");
        titleMap.put(4, "填空题");
        titleMap.put(5, "简答题");
    };

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

    @Override
    public TAnswerInfoResVO getAnswerInfo(Long paId) {
        return tAnswerMapper.selectAnswerInfo(paId);
    }

    @Override
    public List<TAnswerTitleItemResVO> getAnswerTitleItem(Long paId) {
        List<TAnswerTitleItemResVO> res = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<TAnswerQuestionItemResVO> recordList = tAnswerMapper.selectAnswerQuestionItem(paId, i + 1);
            if (recordList.isEmpty()) {
                continue;
            }
            // 客观题设置前缀
            if (i < 2) {
                for (int j = 0; j < recordList.size(); j++) {
                    char ch = 'A';
                    for (int k = 0; k < recordList.get(j).getOptions().size(); k++) {
                        recordList.get(j).getOptions().get(k).setPrefix(ch++);
                    }
                }
            }
            TAnswerTitleItemResVO titleItemResVO = new TAnswerTitleItemResVO(i + 1, titleMap.get(i + 1), null);
            titleItemResVO.setQuestionList(recordList);
            res.add(titleItemResVO);
        }
        return res;
    }

    @Override
    public void submitCheckAnswer(TAnswerCheckInfoReqVO vo) {
        Long paId = vo.getPaId();
        Map<Long, Double> scoreList = vo.getAnswerScore();
        if (scoreList == null) {
            return;
        }
        // 1. 新增正确题目数(主观题没有满分统一算错)
        int addRightNum = 0;
        // 2. 新增答题总分
        double addScore = 0;
        for (Map.Entry<Long, Double> entry : scoreList.entrySet()) {
            Long questionId = entry.getKey();
            Double score = entry.getValue();
            // 1. 判断题目是否正确(检查score得分和题目原本得分是否一致)
            Integer isRight = tAnswerMapper.selectIsRight(questionId, score);
            if (isRight != 0) {
                addRightNum++;
            }
            addScore += score;
            // 2. 更新pqa记录
            tAnswerMapper.updateAnswerQuestion(paId, questionId, isRight, score);
        }
        // 查询答卷是否所有题目已阅
        Integer isAllRead = tAnswerMapper.selectIsAllRead(paId);
        int paState = 0;
        if (isAllRead == 0) {
            paState = 1;
        }
        // 更新pa记录
        tAnswerMapper.updateAnswerRecord(paId, addRightNum, addScore, paState);
    }
}
