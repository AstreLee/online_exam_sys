package com.xin.online_exam_sys.service.student.Impl;

import com.xin.online_exam_sys.dao.student.SLoginMapper;
import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.entity.Student;
import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.UserLoginVO;
import com.xin.online_exam_sys.service.student.SLoginService;
import com.xin.online_exam_sys.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : AstreLee
 * @date : 2024/1/13 - 20:37
 * @file : SLoginServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class SLoginServiceImpl implements SLoginService {
    @Autowired
    private SLoginMapper sLoginMapper;

    @Override
    public ResultVO getByIdAndPasswd(UserLoginVO userLoginVO) {
        // 根据id和password查询teacher表
        Long userId = userLoginVO.getUserId();
        String userPasswd = userLoginVO.getUserPasswd();
        Student s = sLoginMapper.selectByIdAndPasswd(userId, userPasswd);
        // 1. t为空说明账号或者密码不正确
        if (s == null) {
            return ResultVO.error(HttpStatusCode.BAD_REQUEST);
        } else {
            // 2. 账号密码正确授权token
            String data = JWTUtil.createAccessToken(String.valueOf(s.getStuId()), s.getStuName());
            return ResultVO.success(data);
        }
    }
}
