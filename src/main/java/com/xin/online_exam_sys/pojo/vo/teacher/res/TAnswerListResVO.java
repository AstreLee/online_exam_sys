package com.xin.online_exam_sys.pojo.vo.teacher.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAnswerListResVO {
    private Long answerPaperId;
    private String answerPaperName;
    private String username;
    private String className;
    private Double totalScore;
    private Integer state;
    private Integer doTime;
    private String submitTime;
    private String courseName;
}
