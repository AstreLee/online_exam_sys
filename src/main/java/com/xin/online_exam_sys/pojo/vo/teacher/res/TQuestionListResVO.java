package com.xin.online_exam_sys.pojo.vo.teacher.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2023/12/16 - 22:39
 * @file : TeacherQuestionListVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQuestionListResVO {
    private Long questionId;
    private String courseName;
    private Integer questionType;
    private String content;
    private Integer score;
    private Integer difficulty;
    private String createdTime;
}
