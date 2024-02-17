package com.xin.online_exam_sys.pojo.vo.student.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @author : AstreLee
 * @date : 2024/2/15 - 16:02
 * @file : SPaperQuestionItemResVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SPaperQuestionItemResVO {
    private Long questionId;
    private Double score;
    private String content;
    private List<SPaperOptionItemResVO> options;
}
