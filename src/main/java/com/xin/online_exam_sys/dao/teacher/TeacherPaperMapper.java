package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.response.teacher.TPaperAddQuestionTableResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TSelectOptionResVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2024/1/2 - 10:19
 * @file : TeacherPaperMapper.java
 * @ide : IntelliJ IDEA
 */
@Mapper
public interface TeacherPaperMapper {
    // 查询课程选项
    List<TSelectOptionResVO> selectCourseOptions(@Param("tId") Long tId);

    // 查询试题
    List<TPaperAddQuestionTableResVO> selectQuestions(@Param("questionId") Long questionId, @Param("courseId") Long courseId, @Param("questionType") Integer questionType);
}
