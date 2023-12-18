package com.xin.online_exam_sys.service.teacher;

import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/17 - 16:52
 * @file : TeacherDashboardService.java
 * @ide : IntelliJ IDEA
 */
public interface TeacherDashboardService {
    // 获取试卷量、试题量、已完成试卷量、已完成试题量
    Map<String, Integer> getDashboardInfo();
}
