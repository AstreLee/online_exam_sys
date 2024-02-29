package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.service.teacher.TDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher/dashboardInfo")
public class TDashboardController {
    private final TDashboardService tDashboardService;

    public TDashboardController(TDashboardService tDashboardService) {
        this.tDashboardService = tDashboardService;
    }

    @GetMapping("")
    public ResultVO getDashboardInfo() {
        Object data = tDashboardService.getDashboardInfo();
        return ResultVO.success(data);
    }
}
