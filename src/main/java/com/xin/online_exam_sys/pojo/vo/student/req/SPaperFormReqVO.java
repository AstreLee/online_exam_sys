package com.xin.online_exam_sys.pojo.vo.student.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SPaperFormReqVO {
    private Long paperId;
    private Integer doTime;
    private String submitTime;
    private Integer taskType;
    private List<List<SPaperFormAnswerItemReqVO>> paperAnswer;
}
