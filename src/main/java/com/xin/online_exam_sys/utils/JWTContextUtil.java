package com.xin.online_exam_sys.utils;

/**
 * @author : AstreLee
 * @date : 2023/12/4 - 9:19
 * @file : Context.java
 * @ide : IntelliJ IDEA
 */
public class JWTContextUtil {

    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }
}
