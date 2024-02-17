package com.xin.online_exam_sys.pojo.vo.student.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2024/2/15 - 21:14
 * @file : SPaperFormAnswerItemReqVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SPaperFormAnswerItemReqVO {
    private Long questionId;
    private String answer;
}
