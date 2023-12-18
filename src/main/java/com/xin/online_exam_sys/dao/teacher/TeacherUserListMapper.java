package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOptionResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserListInfoResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserUpdateInfoResVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2023/12/8 - 22:30
 * @file : UserListMapper.java
 * @ide : IntelliJ IDEA
 */
@Mapper
public interface TeacherUserListMapper {
    List<Integer> selectGradeOptions(@Param("userId") Long userId, @Param("classId") Long classId, @Param("tId") Long tId);

    List<TeacherSelectOptionResVO> selectClassOptions(@Param("userId") Long userId, @Param("grade") Integer grade, @Param("tId") Long tId);

    List<TeacherUserListInfoResVO> selectList(@Param("userId") Long userId, @Param("grade") Integer grade, @Param("classId") Long classId, @Param("tId") Long tId);

    TeacherUserUpdateInfoResVO selectInfoById(@Param("userId") Long userId);

    void updateInfoById(@Param("userId") Long userId,
                        @Param("phone") String phone,
                        @Param("email") String email);
}
