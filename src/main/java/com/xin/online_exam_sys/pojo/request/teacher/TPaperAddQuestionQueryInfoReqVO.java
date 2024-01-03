package com.xin.online_exam_sys.pojo.request.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2024/1/2 - 23:11
 * @file : TeacherPaperQuestionListQueryInfoReqVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TPaperAddQuestionQueryInfoReqVO {
    private Long courseId;
    private Long questionId;
    private Integer questionType;
    private Integer pageNum;
    private Integer pageSize;
}
