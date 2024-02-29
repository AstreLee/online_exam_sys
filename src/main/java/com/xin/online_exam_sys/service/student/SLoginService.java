package com.xin.online_exam_sys.service.student;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.UserLoginVO;


public interface SLoginService {
    ResultVO getByIdAndPasswd(UserLoginVO userLoginVO);
}
