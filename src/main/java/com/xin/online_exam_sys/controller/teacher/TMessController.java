package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TMessAddFormReqVO;
import com.xin.online_exam_sys.service.teacher.TMessService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher/message")
public class TMessController {
    private final TMessService tMessService;

    public TMessController(TMessService tMessService) {
        this.tMessService = tMessService;
    }

    @GetMapping("")
    public ResultVO getMessageList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return ResultVO.success(tMessService.getMessageList(pageNum, pageSize));
    }

    @GetMapping("/class")
    public ResultVO getClassList() {
        return ResultVO.success(tMessService.getClassList());
    }

    @GetMapping("/student")
    public ResultVO getStudentList() {
        return ResultVO.success(tMessService.getStuList());
    }

    @PostMapping("")
    public ResultVO saveMessage(@RequestBody TMessAddFormReqVO vo) {
        tMessService.saveMessage(vo);
        return ResultVO.success();
    }
}
