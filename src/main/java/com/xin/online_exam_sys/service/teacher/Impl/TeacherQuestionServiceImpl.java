package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TeacherQuestionMapper;
import com.xin.online_exam_sys.pojo.entity.Question;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQuestionFormVO;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQuestionOptionVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOption;
import com.xin.online_exam_sys.service.teacher.TeacherQuestionService;
import com.xin.online_exam_sys.utils.DateTimeUtil;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2023/12/14 - 15:58
 * @file : TeacherQuestionServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class TeacherQuestionServiceImpl implements TeacherQuestionService {
    @Autowired
    private TeacherQuestionMapper teacherQuestionMapper;
    @Override
    public List<TeacherSelectOption> getCourseOptions() {
        Long tId = JWTContextUtil.getCurrentId();
        return teacherQuestionMapper.selectCourseOptions(tId);
    }

    @Override
    public void saveQuestionAndOptions(TeacherQuestionFormVO questionFormVO) {
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
        teacherQuestionMapper.insertQuestion(question);
        // 插入选项
        List<TeacherQuestionOptionVO> optionList = questionFormVO.getItems();
        for (int i = 0; i < optionList.size(); ++i) {
            teacherQuestionMapper.insertQuestionOptions(question.getQId(), optionList.get(i).getContent(), optionList.get(i).getOrder());
        }
    }
}
