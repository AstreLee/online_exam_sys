package com.xin.online_exam_sys.pojo.vo.teacher.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TMessListResVO {
    private Integer messageId;
    private Integer messageType;
    private String messageRecvName;
    private Integer messageRecvSum;
    private String messageTime;
    private String messageTitle;
    private String messageContent;
}
