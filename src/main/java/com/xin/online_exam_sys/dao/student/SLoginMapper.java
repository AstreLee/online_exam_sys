package com.xin.online_exam_sys.dao.student;

import com.xin.online_exam_sys.pojo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface SLoginMapper {
    Student selectByIdAndPasswd(@Param("userId") Long userId, @Param("userPasswd") String userPasswd);
}
