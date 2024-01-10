package com.xin.online_exam_sys.controller.teacher;


import com.xin.online_exam_sys.pojo.vo.UserLoginVO;
import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.service.teacher.TLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author : AstreLee
 * @date : 2023/12/4 - 9:46
 * @file : LoginService.java
 * @ide : IntelliJ IDEA
 */
@RestController
@RequestMapping("/teacher")
public class TeacherLoginController {
    @Autowired
    private TLoginService tLoginService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody UserLoginVO userLoginVO) {
        return tLoginService.getByIdAndPasswd(userLoginVO);
    }

    @GetMapping("/info")
    public ResultVO getUserInfo() {
        return tLoginService.getUserInfo();
    }
}
