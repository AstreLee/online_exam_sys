package com.xin.online_exam_sys.dao.student;

import com.xin.online_exam_sys.pojo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : AstreLee
 * @date : 2024/1/13 - 20:41
 * @file : SLoginMapper.java
 * @ide : IntelliJ IDEA
 */
@Mapper
public interface SLoginMapper {
    Student selectByIdAndPasswd(@Param("userId") Long userId, @Param("userPasswd") String userPasswd);
}
