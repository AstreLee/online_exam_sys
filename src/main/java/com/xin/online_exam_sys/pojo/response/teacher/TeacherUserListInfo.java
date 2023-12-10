package com.xin.online_exam_sys.pojo.response.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2023/12/8 - 22:41
 * @file : UserListInfo.java
 * @ide : IntelliJ IDEA
 */
@Data
public class TeacherUserListInfo {
    private Long userId;
    private String userName;
    private Integer age;
    private Integer gender;
    private String phone;
    private String email;
    private Integer grade;
    private String collegeName;
    private String majorName;
    private String className;
}
