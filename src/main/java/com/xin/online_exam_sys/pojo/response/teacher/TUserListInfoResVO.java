package com.xin.online_exam_sys.pojo.response.teacher;

import lombok.Data;

/**
 * @author : AstreLee
 * @date : 2023/12/8 - 22:41
 * @file : UserListInfo.java
 * @ide : IntelliJ IDEA
 */
@Data
public class TUserListInfoResVO {
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
