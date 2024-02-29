package com.xin.online_exam_sys.service.teacher;

import java.util.Map;

public interface TDashboardService {
    // 获取试卷量、试题量、已完成试卷量、已完成试题量
    Map<String, Integer> getDashboardInfo();
}
