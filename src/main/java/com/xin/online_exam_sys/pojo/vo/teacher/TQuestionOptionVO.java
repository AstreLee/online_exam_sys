package com.xin.online_exam_sys.pojo.vo.teacher;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2023/12/17 - 10:08
 * @file : TeacherQuestionOptionVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQuestionOptionVO {
    private Character prefix;
    private Long questionId;
    private String content;
    private Integer order;
}
