package com.xin.online_exam_sys.pojo.vo.student.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SMessListResVO {
    private Long messId;
    private Integer messType;
    private String messSendUser;
    private String messSendTime;
    private String messTitle;
    private String messContent;
    private Integer messStatus;
    private Integer readNum;
    private String messConfirmTime;
}
