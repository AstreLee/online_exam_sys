package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQuestionFormReqVO;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQuestionListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.service.teacher.TeacherQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResultVO addQuestion(@RequestBody TeacherQuestionFormReqVO questionFormVO) {
        teacherQuestionService.saveQuestionAndOptions(questionFormVO);
        return ResultVO.success();
    }

    // 获取试题列表
    @PostMapping("/question/list")
    public ResultVO getQuestion(@RequestBody TeacherQuestionListQueryInfoReqVO teacherQuestionListQueryInfoReqVO) {
        Map<String, Object> map = teacherQuestionService.getQuestionList(teacherQuestionListQueryInfoReqVO);
        return ResultVO.success(HttpStatusCode.OK, map);
    }

    // 获取试题
    @GetMapping("/question/{id}")
    public ResultVO getQuestion(@PathVariable Long id) {
        Object data = teacherQuestionService.getQuestionById(id);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    // 更新试题
    @PutMapping("/question")
    public ResultVO updateQuestion(@RequestBody TeacherQuestionFormReqVO questionFormReqVO) {
        // System.out.println(questionFormReqVO);
        teacherQuestionService.updateQuestionById(questionFormReqVO);
        return ResultVO.success();
    }
}
