package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.entity.Question;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQuestionFormReqVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherQuestionFormResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherQuestionListResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOptionResVO;
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
    List<TeacherSelectOptionResVO> selectCourseOptions(@Param("tId") Long tId);

    // 添加题目
    void insertQuestion(Question question);

    // 添加选项
    void insertQuestionOptions(@Param("qId") Long qId,
                               @Param("content") String content,
                               @Param("order") Integer order);

    // 查询题目列表
    List<TeacherQuestionListResVO> selectQuestionList(@Param("courseId") Long courseId,
                                                      @Param("questionType") Integer questionType);


    // 查询题目
    TeacherQuestionFormResVO selectQuestionById(@Param("questionId") Long questionId);

    // 更新题目
    void updateQuestionById(TeacherQuestionFormReqVO questionFormReqVO);
}
