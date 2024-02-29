package com.xin.online_exam_sys.controller.teacher;


import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.UserLoginVO;
import com.xin.online_exam_sys.service.teacher.TLoginService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teacher")
public class TLoginController {
    private final TLoginService tLoginService;
    public TLoginController(TLoginService tLoginService) {
        this.tLoginService = tLoginService;
    }

    @PostMapping("/login")
    public ResultVO login(@RequestBody UserLoginVO userLoginVO) {
        return tLoginService.getByIdAndPasswd(userLoginVO);
    }

    @GetMapping("/info")
    public ResultVO getUserInfo() {
        return tLoginService.getUserInfo();
    }
}
