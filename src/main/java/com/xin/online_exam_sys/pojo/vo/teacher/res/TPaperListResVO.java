package com.xin.online_exam_sys.pojo.vo.teacher.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2024/1/5 - 14:30
 * @file : TPaperListResVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TPaperListResVO {
    private Long paperId;
    private String paperName;
    private String courseName;
    private String createTime;
    private String createUser;
}
