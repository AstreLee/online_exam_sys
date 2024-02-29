package com.xin.online_exam_sys.controller.student;


import com.xin.online_exam_sys.annotation.Loggable;
import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.UserLoginVO;
import com.xin.online_exam_sys.service.student.SLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/student")
public class SLoginController {

    private final SLoginService sLoginService;

    public SLoginController(SLoginService sLoginService) {
        this.sLoginService = sLoginService;
    }

    @Loggable("用户登录")
    @PostMapping("/login")
    public ResultVO login(@RequestBody UserLoginVO userLoginVO) {
        return sLoginService.getByIdAndPasswd(userLoginVO);
    }
}