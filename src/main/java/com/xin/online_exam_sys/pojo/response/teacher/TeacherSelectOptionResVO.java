package com.xin.online_exam_sys.pojo.response.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2023/12/9 - 9:05
 * @file : GradeOptions.java
 * @ide : IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherSelectOptionResVO {
    private String label;   // 标签名
    private Integer value;  // 标签值
}
