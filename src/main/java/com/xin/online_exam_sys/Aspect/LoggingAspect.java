package com.xin.online_exam_sys.Aspect;

import com.xin.online_exam_sys.annotation.Loggable;
import com.xin.online_exam_sys.pojo.entity.SysLog;
import com.xin.online_exam_sys.service.teacher.TLogService;
import com.xin.online_exam_sys.utils.DateTimeUtil;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final TLogService tLogService;

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    public LoggingAspect(TLogService tLogService) {
        this.tLogService = tLogService;
    }
    @AfterReturning("@annotation(loggable)")
    public void logMethodCall(JoinPoint joinPoint, Loggable loggable) {
        Long userId = JWTContextUtil.getCurrentId();
        // 构建插入对象
        SysLog syslog = new SysLog();
        syslog.setLogUserId(userId);
        syslog.setLogContent(loggable.value());
        syslog.setLogCreatedTime(DateTimeUtil.getCurrentFormattedDateTime());
        // 插入日志对象
        tLogService.saveLog(syslog);
    }
}
