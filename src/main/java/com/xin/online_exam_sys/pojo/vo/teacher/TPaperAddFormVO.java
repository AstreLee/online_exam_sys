package com.xin.online_exam_sys.pojo.vo.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2024/1/3 - 16:59
 * @file : TPaperAddFormVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TPaperAddFormVO {
    private Long paperId;
    private Long courseId;
    private Integer paperType;
    private String startTime;
    private String endTime;
    private String paperName;
    private Integer suggestTime;
    private List<TPaperAddFormTitleItemsVO> titleItems;
}
