package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.request.teacher.TPaperAddFormReqVO;
import com.xin.online_exam_sys.pojo.request.teacher.TPaperAddQuestionQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.service.teacher.TPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : AstreLee
 * @date : 2024/1/2 - 10:24
 * @file : TeacherPaperController.java
 * @ide : IntelliJ IDEA
 */
@RestController
@RequestMapping("/teacher/paper")
public class TeacherPaperController {
    @Autowired
    private TPaperService tPaperService;

    @GetMapping("/courseOptions")
    public ResultVO getCourseOptions() {
        return ResultVO.success(HttpStatusCode.OK, tPaperService.getCourseOptions());
    }

    @PostMapping("/questionList")
    public ResultVO getQuestionList(@RequestBody TPaperAddQuestionQueryInfoReqVO reqVO) {
        System.out.println(reqVO);
        return ResultVO.success(HttpStatusCode.OK, tPaperService.getQuestionList(reqVO));
    }

    @PostMapping("")
    public ResultVO addPaper(@RequestBody TPaperAddFormReqVO reqVO) {
        System.out.println(reqVO);
        return ResultVO.success();
    }
}
