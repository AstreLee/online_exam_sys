package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.entity.Question;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2023/12/14 - 13:50
 * @file : TeacherQuestionMappre.java
 * @ide : IntelliJ IDEA
 */
@Mapper
public interface TeacherQuestionMapper {
    // 获取课程集合
    List<TeacherSelectOption> selectCourseOptions(@Param("tId") Long tId);

    // 添加题目
    void insertQuestion(Question question);

    // 添加选项
    void insertQuestionOptions(@Param("qId") Long qId,
                               @Param("content") String content,
                               @Param("order") Integer order);
}
