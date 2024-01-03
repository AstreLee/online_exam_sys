package com.xin.online_exam_sys.pojo.request.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @author : AstreLee
 * @date : 2024/1/3 - 21:32
 * @file : TPaperAddFormTitleItemsReqVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TPaperAddFormTitleItemsReqVO {
    private Long titleId;
    private String titleName;
    private List<TPaperAddFormQuestionItemsReqVO> questionItems;
}
