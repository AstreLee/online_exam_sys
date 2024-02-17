package com.xin.online_exam_sys.pojo.vo.student.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2024/2/15 - 12:18
 * @file : SPaperInfoResVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SPaperInfoResVO {
    private String paperName;
    private Integer examTime;
    private Double examScore;
    private Integer totalNum;
}
