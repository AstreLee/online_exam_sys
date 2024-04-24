package com.xin.online_exam_sys.controller.student;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.service.student.SMessService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/mess")
public class SMessController {
    private final SMessService messService;
    public SMessController(SMessService messService) {
        this.messService = messService;
    }

    // 获取消息列表
    @GetMapping("/list")
    public ResultVO list(@RequestParam("messType") Integer messType){
        Long stuId = JWTContextUtil.getCurrentId();
        return ResultVO.success(messService.getMessList(stuId, messType));
    }

    // 确认消息已读
    @GetMapping("/confirm")
    public ResultVO confirm(@RequestParam("messId") Long messId) {
        Long stuId = JWTContextUtil.getCurrentId();
        messService.saveMessConfirm(stuId, messId);
        return ResultVO.success();
    }
}
