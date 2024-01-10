package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.entity.Paper;
import com.xin.online_exam_sys.pojo.vo.teacher.TPaperAddFormQuestionItemsVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TPaperAddFormVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TPaperAddQuestionTableResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TPaperListResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TSelectOptionResVO;
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

    // 插入试卷
    void insertPaper(@Param("paper") Paper paper);

    // 插入试卷题目列表
    void insertPaperQuestionList(@Param("paperId") Long paperId, @Param("questionIds") List<Long> questionIds);

    // 查询试卷
    List<TPaperListResVO> selectPaperList(@Param("paperId") Long paperId, @Param("courseId") Long courseId);

    // 根据试卷id查询题目类型
    List<Integer> selectQuestionTypeByPaperId(@Param("paperId") Long paperId);

    // 查询对应题目类型有哪些题目
    List<Long> selectQuestionByType(@Param("paperId") Long paperId, @Param("questionType") Integer questionType);

    // 查询对应题目详情
    List<TPaperAddFormQuestionItemsVO> selectQuestionDetail(@Param("questionIds") List<Long> questionIds);

    // 查询试卷信息
    TPaperAddFormVO selectPaperDetail(@Param("paperId") Long paperId);
}
