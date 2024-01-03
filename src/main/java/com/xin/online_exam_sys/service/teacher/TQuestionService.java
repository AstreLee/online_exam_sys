package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.request.teacher.TQuestionFormReqVO;
import com.xin.online_exam_sys.pojo.request.teacher.TQuestionListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.teacher.TQuestionFormResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TSelectOptionResVO;

import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/14 - 15:57
 * @file : TeacherQuestionService.java
 * @ide : IntelliJ IDEA
 */
public interface TQuestionService {
    // 获取所有课程集合
    List<TSelectOptionResVO> getCourseOptions();

    // 添加题目和选项
    void saveQuestionAndOptions(TQuestionFormReqVO questionFormVO);

    // 获取试题列表
    Map<String, Object> getQuestionList(TQuestionListQueryInfoReqVO questionListQueryInfoVO);

    // 获取试题
    TQuestionFormResVO getQuestionById(Long questionId);

    // 更新试题
    void updateQuestionById(TQuestionFormReqVO questionFormReqVO);
}
