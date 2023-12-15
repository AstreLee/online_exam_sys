package com.xin.online_exam_sys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateTimeUtil {
    public static String getCurrentFormattedDateTime() {
        // 创建 SimpleDateFormat 对象，指定日期时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yy:MM:dd HH:mm:ss");
        // 获取当前时间
        Date now = new Date();
        // 格式化时间
        return sdf.format(now);
    }
}
