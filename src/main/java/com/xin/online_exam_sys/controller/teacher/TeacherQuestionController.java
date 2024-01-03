package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.request.teacher.TQuestionFormReqVO;
import com.xin.online_exam_sys.pojo.request.teacher.TQuestionListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.service.teacher.TQuestionService;
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
    private TQuestionService tQuestionService;

    // 获取课程列表
    @GetMapping("/question/courseOptions")
    public ResultVO getCourseOptions() {
        Object data = tQuestionService.getCourseOptions();
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    // 添加试题
    @PostMapping("/question")
    public ResultVO addQuestion(@RequestBody TQuestionFormReqVO questionFormVO) {
        tQuestionService.saveQuestionAndOptions(questionFormVO);
        return ResultVO.success();
    }

    // 获取试题列表
    @PostMapping("/question/list")
    public ResultVO getQuestion(@RequestBody TQuestionListQueryInfoReqVO tQuestionListQueryInfoReqVO) {
        Map<String, Object> map = tQuestionService.getQuestionList(tQuestionListQueryInfoReqVO);
        return ResultVO.success(HttpStatusCode.OK, map);
    }

    // 获取试题
    @GetMapping("/question/{id}")
    public ResultVO getQuestion(@PathVariable Long id) {
        Object data = tQuestionService.getQuestionById(id);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    // 更新试题
    @PutMapping("/question")
    public ResultVO updateQuestion(@RequestBody TQuestionFormReqVO questionFormReqVO) {
        // System.out.println(questionFormReqVO);
        tQuestionService.updateQuestionById(questionFormReqVO);
        return ResultVO.success();
    }
}
