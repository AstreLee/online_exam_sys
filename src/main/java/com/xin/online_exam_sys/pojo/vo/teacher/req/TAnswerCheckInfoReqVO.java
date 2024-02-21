package com.xin.online_exam_sys.pojo.vo.teacher.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAnswerCheckInfoReqVO {
    private Long paId;
    private Map<Long, Double> answerScore;
}
