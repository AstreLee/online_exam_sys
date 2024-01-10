package com.xin.online_exam_sys.pojo.vo.teacher.res;

import com.xin.online_exam_sys.pojo.vo.teacher.TQuestionOptionVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


/**
 * @author : AstreLee
 * @date : 2023/12/17 - 10:06
 * @file : TeacherQuestionGetVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQuestionFormResVO {
    // 题目ID
    private Integer questionId;
    // 题目类型
    private Integer questionType;
    // 题目所属课程ID
    private Long courseId;
    // 题目内容
    private String content;
    // 选项内容
    private List<TQuestionOptionVO> items;
    // 题目解析
    private String explanation;
    // 题目答案
    private String answer;
    // 题目分数
    private Integer score;
    // 题目难度
    private Integer difficulty;
}
