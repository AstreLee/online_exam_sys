package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQuestionFormVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.service.teacher.TeacherQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : AstreLee
 * @date : 2023/12/14 - 16:00
 * @file : TeacherQuestion.java
 * @ide : IntelliJ IDEA
 */
@RestController
@RequestMapping("/teacher")
public class TeacherQuestionController {
    @Autowired
    private TeacherQuestionService teacherQuestionService;

    // 获取课程列表
    @GetMapping("/question/courseOptions")
    public ResultVO getCourseOptions() {
        Object data = teacherQuestionService.getCourseOptions();
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    // 添加试题
    @PostMapping("/question")
    public ResultVO addQuestion(@RequestBody TeacherQuestionFormVO questionFormVO) {
        teacherQuestionService.saveQuestionAndOptions(questionFormVO);
        System.out.println(questionFormVO);
        return ResultVO.success();
    }
}
