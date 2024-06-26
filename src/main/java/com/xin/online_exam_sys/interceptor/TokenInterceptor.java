package com.xin.online_exam_sys.interceptor;


import com.xin.online_exam_sys.config.JWTConfig;
import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.exception.SignatureException;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws SignatureException {
        // if preflight, return true
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }
        // 获取token
        String token = request.getHeader(JWTConfig.tokenHeader);
        // token为空抛出异常
        if (StringUtils.isEmpty(token)) {
            throw new SignatureException(HttpStatusCode.UNAUTHORIZED.getCode(), "token为空");
        }
        Claims claims = JWTUtil.getTokenClaim(token);
        // token过期抛出异常
        if (claims.getExpiration().before(new Date())) {
            throw new SignatureException(HttpStatusCode.UNAUTHORIZED.getCode(), "token已经过期！");
        }
        // 设置用户id
        long userId = Long.parseLong(claims.getId());
        JWTContextUtil.setCurrentId(userId);
        return true;
    }
}
