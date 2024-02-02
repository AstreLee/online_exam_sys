package com.xin.online_exam_sys.dao.teacher;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : AstreLee
 * @date : 2023/12/17 - 16:35
 * @file : TDashboardMapper.java
 * @ide : IntelliJ IDEA
 */
@Mapper
public interface TDashboardMapper {
    // 试卷数量
    Integer selectPaperCount(@Param("tId") Long tId);

    // 试题数量
    Integer selectQuestionCount(@Param("tId") Long tId);

    // 已经完成试卷数量
    Integer selectDoPaperCount(@Param("tId") Long tId);

    // 已经完成的试题的数量
    Integer selectDoQuestionCount(@Param("tId") Long tId);
}
