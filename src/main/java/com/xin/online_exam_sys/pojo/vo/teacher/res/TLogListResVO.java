package com.xin.online_exam_sys.pojo.vo.teacher.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TLogListResVO {
    private Long logId;
    private Long logUserId;
    private String logUserName;
    private String logUserClass;
    private String logContent;
    private String logTime;
}
