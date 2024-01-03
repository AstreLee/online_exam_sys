package com.xin.online_exam_sys.pojo.response.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2024/1/3 - 11:04
 * @file : TPaperAddQuestionTableResVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TPaperAddQuestionTableResVO {
    // 题目ID
    private Long questionId;
    // 题目内容
    private String content;
    // 选项内容
    private List<TQuestionOptionResVO> items;
}
