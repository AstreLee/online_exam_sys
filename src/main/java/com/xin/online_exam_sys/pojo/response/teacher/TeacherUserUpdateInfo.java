package com.xin.online_exam_sys.pojo.response.teacher;

import lombok.Data;

/**
 * @author : AstreLee
 * @date : 2023/12/11 - 10:48
 * @file : TeacherUserUpdateInfo.java
 * @ide : IntelliJ IDEA
 */
@Data
public class TeacherUserUpdateInfo {
    private Long userId;
    private String userName;
    private String phone;
    private String email;
}
