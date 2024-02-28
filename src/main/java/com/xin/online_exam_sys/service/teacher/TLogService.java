package com.xin.online_exam_sys.service.teacher;


import com.xin.online_exam_sys.pojo.entity.SysLog;

import java.util.Map;

public interface TLogService {
    void saveLog(SysLog sysLog);

    Map<String, Object> getLogList(Integer pageNum, Integer pageSize);
}
