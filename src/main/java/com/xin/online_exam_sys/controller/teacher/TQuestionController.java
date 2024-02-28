package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TQuestionFormReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TQuestionListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.service.teacher.TQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/teacher/question")
public class TQuestionController {
    @Autowired
    private TQuestionService tQuestionService;

    // 获取课程列表
    @GetMapping("/courseOptions")
    public ResultVO getCourseOptions() {
        Object data = tQuestionService.getCourseOptions();
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    // 添加试题
    @PostMapping("")
    public ResultVO addQuestion(@RequestBody TQuestionFormReqVO questionFormVO) {
        tQuestionService.saveQuestionAndOptions(questionFormVO);
        return ResultVO.success();
    }

    // 获取试题列表
    @PostMapping("/list")
    public ResultVO getQuestion(@RequestBody TQuestionListQueryInfoReqVO tQuestionListQueryInfoReqVO) {
        Map<String, Object> map = tQuestionService.getQuestionList(tQuestionListQueryInfoReqVO);
        return ResultVO.success(HttpStatusCode.OK, map);
    }

    // 获取试题
    @GetMapping("/{id}")
    public ResultVO getQuestion(@PathVariable Long id) {
        Object data = tQuestionService.getQuestionById(id);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    // 更新试题
    @PutMapping("")
    public ResultVO updateQuestion(@RequestBody TQuestionFormReqVO questionFormReqVO) {
        // System.out.println(questionFormReqVO);
        tQuestionService.updateQuestionById(questionFormReqVO);
        return ResultVO.success();
    }
}
