package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.vo.UserLoginVO;
import com.xin.online_exam_sys.pojo.vo.ResultVO;


public interface TLoginService {
    ResultVO getByIdAndPasswd(UserLoginVO userLoginVO);
    ResultVO getUserInfo();
}
