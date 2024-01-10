package com.xin.online_exam_sys.pojo.vo.teacher.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2024/1/5 - 14:29
 * @file : TPaperListQueryInfoReqVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TPaperListQueryInfoReqVO {
    private Long paperId;
    private Long courseId;
    private Integer pageNum;
    private Integer pageSize;
}
