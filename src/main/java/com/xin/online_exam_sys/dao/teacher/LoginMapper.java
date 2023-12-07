package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.entity.Teacher;
import com.xin.online_exam_sys.pojo.response.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    Teacher selectByIdAndPasswd(@Param("userId") Long userId, @Param("userPasswd") String userPasswd);

    UserInfo selectUserInfo(@Param("userId") Long userId);
}
