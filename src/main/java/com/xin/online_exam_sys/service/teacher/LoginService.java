package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.entity.Teacher;
import com.xin.online_exam_sys.pojo.request.UserLoginVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import org.springframework.stereotype.Service;

/**
 * @author : AstreLee
 * @date : 2023/12/4 - 16:22
 * @file : LoginService.java
 * @ide : IntelliJ IDEA
 */
public interface LoginService {
    ResultVO getByIdAndPasswd(UserLoginVO userLoginVO);
    ResultVO getUserInfo();
}
