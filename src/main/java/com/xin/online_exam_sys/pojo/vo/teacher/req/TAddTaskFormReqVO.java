package com.xin.online_exam_sys.pojo.vo.teacher.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2024/4/9 - 16:29
 * @file : TAddTaskFormReqVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAddTaskFormReqVO {
    private Integer taskType;
    private Long taskRecvId;
    private Long taskPaperId;
}
