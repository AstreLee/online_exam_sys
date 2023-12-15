package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.request.teacher.TeacherQuestionFormVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOption;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2023/12/14 - 15:57
 * @file : TeacherQuestionService.java
 * @ide : IntelliJ IDEA
 */
public interface TeacherQuestionService {
    // 获取所有课程集合
    List<TeacherSelectOption> getCourseOptions();

    // 添加题目和选项
    void saveQuestionAndOptions(TeacherQuestionFormVO questionFormVO);
}
