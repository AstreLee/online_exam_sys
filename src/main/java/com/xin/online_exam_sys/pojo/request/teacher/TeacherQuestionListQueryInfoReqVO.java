package com.xin.online_exam_sys.pojo.request.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2023/12/16 - 23:14
 * @file : TeacherQuestionListQueryInfoVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherQuestionListQueryInfoReqVO {
    private Long courseId;
    private Integer questionType;
    private Integer pageNum;
    private Integer pageSize;
}
