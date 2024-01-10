package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.vo.UserLoginVO;
import com.xin.online_exam_sys.pojo.vo.ResultVO;

/**
 * @author : AstreLee
 * @date : 2023/12/4 - 16:22
 * @file : LoginService.java
 * @ide : IntelliJ IDEA
 */
public interface TLoginService {
    ResultVO getByIdAndPasswd(UserLoginVO userLoginVO);
    ResultVO getUserInfo();
}
