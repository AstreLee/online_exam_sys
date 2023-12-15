package com.xin.online_exam_sys.pojo.request.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2023/12/14 - 16:13
 * @file : TeacherQuestionFormVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherQuestionFormVO {
    // 问题类型：0/1/2/3/4：单选、多选、判断、填空、简答
    private Integer questionType;
    // 题目所属课程ID
    private Long courseId;
    // 题目内容
    private String content;
    // 选项内容
    private List<TeacherQuestionOptionVO> items;
    // 题目解析
    private String explanation;
    // 题目答案
    private String answer;
    // 题目分数
    private Integer score;
    // 题目难度
    private Integer difficulty;
}
