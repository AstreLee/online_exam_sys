package com.xin.online_exam_sys.pojo.vo.teacher.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TMessAddFormReqVO {
    private Integer messageType;
    private Long messageRecvId;
    private String messageTitle;
    private String messageContent;
}
