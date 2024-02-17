package com.xin.online_exam_sys.pojo.vo.teacher.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAnswerQueryInfoReqVO {
    private Long courseId;
    private Integer state;
    private Integer pageNum;
    private Integer pageSize;
}
