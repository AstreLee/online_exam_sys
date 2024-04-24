package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAddTaskFormReqVO;
import com.xin.online_exam_sys.service.teacher.TTaskService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @author : AstreLee
 * @date : 2024/4/9 - 15:22
 * @file : TTaskController.java
 * @ide : IntelliJ IDEA
 */
@RestController
@RequestMapping("/teacher/task")
public class TTaskController {
    private final TTaskService tTaskService;
    public TTaskController(TTaskService tMessService) {
        this.tTaskService = tMessService;
    }

    @GetMapping("/class")
    public ResultVO getClassList() {
        return ResultVO.success(tTaskService.getClassList());
    }

    @GetMapping("/student")
    public ResultVO getStudentList() {
        return ResultVO.success(tTaskService.getStuList());
    }

    @GetMapping("/paper")
    public ResultVO getPaperList() {
        return ResultVO.success(tTaskService.getPaperList());
    }

    @GetMapping("/list")
    public ResultVO getTaskList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return ResultVO.success(tTaskService.getTaskList(pageNum, pageSize));
    }

    @PostMapping("/submit")
    public ResultVO submitTask(@RequestBody TAddTaskFormReqVO vo) {
        Long tId = JWTContextUtil.getCurrentId();
        tTaskService.submitTask(tId, vo);
        return ResultVO.success();
    }
}
