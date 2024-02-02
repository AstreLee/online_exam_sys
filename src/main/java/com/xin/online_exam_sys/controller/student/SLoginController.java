package com.xin.online_exam_sys.controller.student;


import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.UserLoginVO;
import com.xin.online_exam_sys.service.student.SLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/student")
public class SLoginController {
    @Autowired
    private SLoginService sLoginService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody UserLoginVO userLoginVO) {
        return sLoginService.getByIdAndPasswd(userLoginVO);
    }
}