package com.xin.online_exam_sys.interceptor;


import com.xin.online_exam_sys.config.JWTConfig;
import com.xin.online_exam_sys.exception.SignatureException;
import com.xin.online_exam_sys.utils.JWTContext;
import com.xin.online_exam_sys.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Date;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws SignatureException {
        // 获取token
        String token = request.getHeader(JWTConfig.tokenHeader);
        // token为空抛出异常
        if (StringUtils.isEmpty(token)) {
            throw new SignatureException(401, "token为空");
        }
        Claims claims;
        try {
            claims = JWTUtils.getTokenClaim(token);
            // token过期抛出异常
            if (claims.getExpiration().before(new Date())) {
                throw new SignatureException(401, "token已经过期！");
            }
        } catch (Exception e) {
            throw new SignatureException(401, "token无效！");
        }
        // 添加到ThreadLocal线程池中，方便获取当前用户ID
        JWTContext.setCurrentId(Long.parseLong(claims.getId()));
        return true;
    }
}
