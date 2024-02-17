package com.xin.online_exam_sys.pojo.vo.student.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2024/2/15 - 10:30
 * @file : SPaperListResVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SPaperListResVO {
    private Long paperId;
    private String paperName;
    private String courseName;
    private Integer totalNum;
    private Integer suggestTime;
    private String startTime;
    private String endTime;
}
