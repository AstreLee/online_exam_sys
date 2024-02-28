package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.service.teacher.TLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher/log")
public class TLogController {
    private final TLogService tLogService;

    public TLogController(TLogService tLogService) {
        this.tLogService = tLogService;
    }

    @GetMapping("")
    public ResultVO getLogList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return ResultVO.success(tLogService.getLogList(pageNum, pageSize));
    }
}
