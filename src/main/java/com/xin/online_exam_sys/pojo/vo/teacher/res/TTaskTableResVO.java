package com.xin.online_exam_sys.pojo.vo.teacher.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2024/4/9 - 15:34
 * @file : TTaskTableResVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TTaskTableResVO {
    private Long taskId;
    private Integer taskType;
    private String taskPaperName;
    private String taskRecvName;
    private String taskCreatedUser;
    private String taskCreatedTime;
}
