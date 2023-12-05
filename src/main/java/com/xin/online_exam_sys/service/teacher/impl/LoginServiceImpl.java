package com.xin.online_exam_sys.service.teacher.impl;

import com.xin.online_exam_sys.dao.teacher.LoginMapper;
import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.entity.Teacher;
import com.xin.online_exam_sys.pojo.request.UserLoginVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.service.teacher.LoginService;
import com.xin.online_exam_sys.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : AstreLee
 * @date : 2023/12/4 - 16:25
 * @file : LoginServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public ResultVO getByIdAndPasswd(UserLoginVO userLoginVO) {
        // 根据id和password查询teacher表
        Long userId = userLoginVO.getUserId();
        String userPasswd = userLoginVO.getUserPasswd();
        Teacher t = loginMapper.selectByIdAndPasswd(userId, userPasswd);
        // 1. t为空说明账号或者密码不正确
        if (t == null) {
            Integer errCode = HttpStatusCode.BAD_REQUEST.getCode();
            System.out.println(errCode);
            String errMsg = "用户名或密码不正确";
            return new ResultVO(errCode, errMsg);
        } else {
            // 2. 账号密码正确授权token
            Integer code = HttpStatusCode.OK.getCode();
            String msg = HttpStatusCode.OK.getEnMsg();
            String data = JWTUtils.createAccessToken(String.valueOf(t.getTId()), t.getTName());
            return new ResultVO(code, msg, data);
        }
    }
}
