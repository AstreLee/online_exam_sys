package com.xin.online_exam_sys.enums;

import lombok.Getter;

/**
 * @author : AstreLee
 * @date : 2023/12/4 - 10:03
 * @file : GenderEnum.java
 * @ide : IntelliJ IDEA
 */
@Getter
public enum GenderEnum {
    MALE(0, "男"),
    FEMALE(1, "女");

    GenderEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    private final Integer code;
    private final String value;
}
