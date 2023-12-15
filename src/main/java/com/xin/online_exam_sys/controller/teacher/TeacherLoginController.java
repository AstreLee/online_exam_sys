package com.xin.online_exam_sys.controller.teacher;


import com.xin.online_exam_sys.pojo.request.UserLoginVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.service.teacher.TeacherLoginService;
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
    private TeacherLoginService teacherLoginService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody UserLoginVO userLoginVO) {
        return teacherLoginService.getByIdAndPasswd(userLoginVO);
    }

    @GetMapping("/info")
    public ResultVO getUserInfo() {
        return teacherLoginService.getUserInfo();
    }
}
