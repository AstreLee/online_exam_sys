package com.xin.online_exam_sys.pojo.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : AstreLee
 * @date : 2023/12/3 - 22:32
 * @file : ResultVO.java
 * @ide : IntelliJ IDEA
 */
@Data
public class ResultVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private Object data;

    public ResultVO() {}

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public ResultVO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}