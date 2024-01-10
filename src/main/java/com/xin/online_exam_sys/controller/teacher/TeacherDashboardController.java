package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.service.teacher.TDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : AstreLee
 * @date : 2023/12/17 - 16:59
 * @file : TeacherDashboardController.java
 * @ide : IntelliJ IDEA
 */
@RestController
@RequestMapping("/teacher")
public class TeacherDashboardController {
    @Autowired
    private TDashboardService tDashboardService;

    @GetMapping("/dashboardInfo")
    public ResultVO getDashboardInfo() {
        Object data = tDashboardService.getDashboardInfo();
        return ResultVO.success(data);
    }
}
