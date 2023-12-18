package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.request.teacher.TeacherQuestionFormReqVO;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQuestionListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherQuestionFormResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOptionResVO;

import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/14 - 15:57
 * @file : TeacherQuestionService.java
 * @ide : IntelliJ IDEA
 */
public interface TeacherQuestionService {
    // 获取所有课程集合
    List<TeacherSelectOptionResVO> getCourseOptions();

    // 添加题目和选项
    void saveQuestionAndOptions(TeacherQuestionFormReqVO questionFormVO);

    // 获取试题列表
    Map<String, Object> getQuestionList(TeacherQuestionListQueryInfoReqVO questionListQueryInfoVO);

    // 获取试题
    TeacherQuestionFormResVO getQuestionById(Long questionId);

    // 更新试题
    void updateQuestionById(TeacherQuestionFormReqVO questionFormReqVO);
}
