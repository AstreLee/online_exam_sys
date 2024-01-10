package com.xin.online_exam_sys.pojo.vo.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @author : AstreLee
 * @date : 2024/1/3 - 21:32
 * @file : TPaperAddFormTitleItemsVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TPaperAddFormTitleItemsVO {
    private Integer titleId;
    private String titleName;
    private List<TPaperAddFormQuestionItemsVO> questionItems;
}
