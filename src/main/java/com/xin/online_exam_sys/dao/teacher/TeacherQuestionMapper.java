package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.entity.Question;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TQuestionFormReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TQuestionFormResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TQuestionListResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TSelectOptionResVO;
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
    List<TSelectOptionResVO> selectCourseOptions(@Param("tId") Long tId);

    // 添加题目
    void insertQuestion(Question question);

    // 添加选项
    void insertQuestionOptions(@Param("qId") Long qId,
                               @Param("content") String content,
                               @Param("order") Integer order);

    // 查询题目列表
    List<TQuestionListResVO> selectQuestionList(@Param("courseId") Long courseId,
                                                @Param("questionType") Integer questionType);


    // 查询题目
    TQuestionFormResVO selectQuestionById(@Param("questionId") Long questionId);

    // 更新题目
    void updateQuestionById(TQuestionFormReqVO questionFormReqVO);
}
