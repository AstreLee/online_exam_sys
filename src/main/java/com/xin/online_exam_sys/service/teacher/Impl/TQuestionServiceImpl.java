package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TQuestionMapper;
import com.xin.online_exam_sys.pojo.entity.Question;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TQuestionFormReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TQuestionListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TQuestionOptionReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TQuestionFormResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TQuestionListResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;
import com.xin.online_exam_sys.service.teacher.TQuestionService;
import com.xin.online_exam_sys.utils.DateTimeUtil;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/14 - 15:58
 * @file : TeacherQuestionServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class TQuestionServiceImpl implements TQuestionService {
    @Autowired
    private TQuestionMapper tQuestionMapper;
    @Override
    public List<TSelectOptionVO> getCourseOptions() {
        Long tId = JWTContextUtil.getCurrentId();
        return tQuestionMapper.selectCourseOptions(tId);
    }

    @Override
    public void saveQuestionAndOptions(TQuestionFormReqVO questionFormVO) {
        Question question = new Question();
        // 这一段没办法...前端如果用qType这种类型的后端根本接收不到
        question.setQType(questionFormVO.getQuestionType());
        question.setQContent(questionFormVO.getContent());
        question.setQAnswer(questionFormVO.getAnswer());
        question.setQExplanation(questionFormVO.getExplanation());
        question.setQScore(questionFormVO.getScore());
        question.setQDifficulty(questionFormVO.getDifficulty());
        question.setQCreatedTime(DateTimeUtil.getCurrentFormattedDateTime());
        question.setCourseId(questionFormVO.getCourseId());
        // 插入题目
        tQuestionMapper.insertQuestion(question);
        // 插入选项
        List<TQuestionOptionReqVO> optionList = questionFormVO.getItems();
        if (optionList.size() == 0) {
            return;
        }
        for (TQuestionOptionReqVO tQuestionOptionReqVO : optionList) {
            tQuestionMapper.insertQuestionOptions(question.getQId(), tQuestionOptionReqVO.getContent(), tQuestionOptionReqVO.getOrder());
        }
    }

    @Override
    public Map<String, Object> getQuestionList(TQuestionListQueryInfoReqVO questionListQueryInfoVO) {
        Long courseId = questionListQueryInfoVO.getCourseId();
        Integer questionType = questionListQueryInfoVO.getQuestionType();
        Integer pageNum = questionListQueryInfoVO.getPageNum();
        Integer pageSize = questionListQueryInfoVO.getPageSize();
        List<TQuestionListResVO> totalList = tQuestionMapper.selectQuestionList(courseId, questionType);
        int total = 0;
        if (totalList.size() == 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("total", 0);
            map.put("data", null);
            return map;
        }
        total = totalList.size();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        List<TQuestionListResVO> newList = new PaginationUtil<TQuestionListResVO>().getLimitCount(pageNum, pageSize, totalList);
        map.put("data", newList);
        return map;
    }

    @Override
    public TQuestionFormResVO getQuestionById(Long questionId) {
        TQuestionFormResVO questionFormVO = tQuestionMapper.selectQuestionById(questionId);
        char ch = 'A';
        if (questionFormVO.getItems() == null) {
            return questionFormVO;
        }
        for (int i = 0; i < questionFormVO.getItems().size(); ++i) {
            questionFormVO.getItems().get(i).setPrefix(ch++);
        }
        return questionFormVO;
    }

    @Override
    public void updateQuestionById(TQuestionFormReqVO questionFormReqVO) {
        tQuestionMapper.updateQuestionById(questionFormReqVO);
    }
}
