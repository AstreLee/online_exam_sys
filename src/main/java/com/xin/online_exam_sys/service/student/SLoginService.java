package com.xin.online_exam_sys.service.student;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.UserLoginVO;

/**
 * @author : AstreLee
 * @date : 2024/1/13 - 20:36
 * @file : SLoginService.java
 * @ide : IntelliJ IDEA
 */
public interface SLoginService {
    ResultVO getByIdAndPasswd(UserLoginVO userLoginVO);
}
