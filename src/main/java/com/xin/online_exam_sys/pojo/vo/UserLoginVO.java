package com.xin.online_exam_sys.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : AstreLee
 * @date : 2023/12/4 - 10:23
 * @file : UserLoginVO.java
 * @ide : IntelliJ IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO {
    private Long userId;
    private String userPasswd;
}
