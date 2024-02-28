package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.service.teacher.TMessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher/message")
public class TMessController {
    private final TMessService tMessService;

    public TMessController(TMessService tMessService) {
        this.tMessService = tMessService;
    }

    @GetMapping("/message")
    public ResultVO getMessageList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return ResultVO.success(tMessService.getMessageList(pageNum, pageSize));
    }
}
