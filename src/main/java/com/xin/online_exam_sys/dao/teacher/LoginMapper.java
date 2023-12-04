package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : AstreLee
 * @date : 2023/12/4 - 10:26
 * @file : LoginMapper.java
 * @ide : IntelliJ IDEA
 */
@Mapper
public interface LoginMapper {
    Teacher selectByIdAndPasswd(@Param("userId") Long userId, @Param("userPasswd") String userPasswd);
}
