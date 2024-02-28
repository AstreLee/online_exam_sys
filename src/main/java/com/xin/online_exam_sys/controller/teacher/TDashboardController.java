package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.service.teacher.TDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TDashboardController {
    @Autowired
    private TDashboardService tDashboardService;

    @GetMapping("/dashboardInfo")
    public ResultVO getDashboardInfo() {
        Object data = tDashboardService.getDashboardInfo();
        return ResultVO.success(data);
    }
}
