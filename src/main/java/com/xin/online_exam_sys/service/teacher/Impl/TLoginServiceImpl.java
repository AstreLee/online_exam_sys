package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TeacherLoginMapper;
import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.entity.Teacher;
import com.xin.online_exam_sys.pojo.vo.UserLoginVO;
import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.UserInfo;
import com.xin.online_exam_sys.service.teacher.TLoginService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : AstreLee
 * @date : 2023/12/4 - 16:25
 * @file : LoginServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class TLoginServiceImpl implements TLoginService {
    @Autowired
    private TeacherLoginMapper teacherLoginMapper;

    @Override
    public ResultVO getByIdAndPasswd(UserLoginVO userLoginVO) {
        // 根据id和password查询teacher表
        Long userId = userLoginVO.getUserId();
        String userPasswd = userLoginVO.getUserPasswd();
        Teacher t = teacherLoginMapper.selectByIdAndPasswd(userId, userPasswd);
        // 1. t为空说明账号或者密码不正确
        if (t == null) {
            Integer errCode = HttpStatusCode.BAD_REQUEST.getCode();
            String errMsg = "用户名或密码不正确";
            return new ResultVO(errCode, errMsg);
        } else {
            // 2. 账号密码正确授权token
            Integer code = HttpStatusCode.OK.getCode();
            String msg = HttpStatusCode.OK.getEnMsg();
            String data = JWTUtil.createAccessToken(String.valueOf(t.getTId()), t.getTName());
            return new ResultVO(code, msg, data);
        }
    }

    @Override
    public ResultVO getUserInfo() {
        // 获取当前用户id
        Long userId = JWTContextUtil.getCurrentId();
        // 根据id查询用户信息
        UserInfo userInfo = teacherLoginMapper.selectUserInfo(userId);
        // 用户信息为空
        if (userInfo == null) {
            // 用户信息为空
            Integer errCode = HttpStatusCode.BAD_REQUEST.getCode();
            String errMsg = "token错误!";
            return new ResultVO(errCode, errMsg);
        } else {
            // 用户信息存在
            Integer code = HttpStatusCode.OK.getCode();
            Integer successCode = HttpStatusCode.OK.getCode();
            String successMsg = HttpStatusCode.OK.getCnMsg();
            return new ResultVO(successCode, successMsg, userInfo);
        }
    }
}
