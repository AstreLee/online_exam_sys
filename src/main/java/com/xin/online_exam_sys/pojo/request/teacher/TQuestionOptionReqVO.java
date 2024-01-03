package com.xin.online_exam_sys.pojo.request.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2023/12/14 - 16:17
 * @file : TeacherQuestionOptionVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQuestionOptionReqVO {
    // 选项内容
    private String content;
    // 选项顺序
    private Integer order;
}
