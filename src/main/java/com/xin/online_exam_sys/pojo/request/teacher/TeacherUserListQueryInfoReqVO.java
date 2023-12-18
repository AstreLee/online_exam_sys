package com.xin.online_exam_sys.pojo.request.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2023/12/8 - 22:32
 * @file : QueryInfoVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherUserListQueryInfoReqVO {
    private Long userId;
    private Integer grade;
    private Long classId;
    private Integer pageNum;
    private Integer pageSize;
}
