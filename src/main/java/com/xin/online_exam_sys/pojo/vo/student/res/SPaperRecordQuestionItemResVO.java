package com.xin.online_exam_sys.pojo.vo.student.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SPaperRecordQuestionItemResVO {
    private Long questionId;
    private String content;
    private String answer;
    private String referenceAnswer;
    private Integer isRight;
    private Integer isRead;
    private Double fullScore;
    private Double score;
    private Integer difficulty;
    private String explanation;
    private List<SPaperOptionItemResVO> options;
}
