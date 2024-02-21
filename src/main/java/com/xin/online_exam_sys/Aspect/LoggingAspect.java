package com.xin.online_exam_sys.Aspect;

import com.xin.online_exam_sys.annotation.Loggable;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @AfterReturning("@annotation(loggable)")
    public void logMethodCall(JoinPoint joinPoint, Loggable loggable) {
        System.out.println("*****");
        System.out.println(JWTContextUtil.getCurrentId());
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // 如果需要记录返回结果，也可以添加到日志中
        logger.info("Method {} returned: {}", methodName, 123);
    }
}
