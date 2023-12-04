package com.xin.online_exam_sys.controller.teacher;


import com.xin.online_exam_sys.pojo.request.UserLoginVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.service.teacher.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author : AstreLee
 * @date : 2023/12/4 - 9:46
 * @file : LoginService.java
 * @ide : IntelliJ IDEA
 */
@RestController
@RequestMapping("/teacher")
public class Login {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    public ResultVO login(@RequestBody UserLoginVO userLoginVO) {
        return loginService.getByIdAndPasswd(userLoginVO);
    }
}
