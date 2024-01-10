package com.xin.online_exam_sys.pojo.vo.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @author : AstreLee
 * @date : 2024/1/3 - 22:57
 * @file : TPaperAddFormQuestionItemsVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TPaperAddFormQuestionItemsVO {
    private Long questionId;
    private String content;
    private List<TQuestionOptionVO> items;
}
