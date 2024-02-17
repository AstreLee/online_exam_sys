package com.xin.online_exam_sys.pojo.vo.student.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @author : AstreLee
 * @date : 2024/2/15 - 16:00
 * @file : SPaperTitleItemResVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SPaperTitleItemResVO {
    private Integer questionType;
    private String titleName;

    private List<SPaperQuestionItemResVO> questionList;

    public SPaperTitleItemResVO(Integer questionType, String titleName) {
        this.questionType = questionType;
        this.titleName = titleName;
    }
}
