package com.xin.online_exam_sys.utils;

import com.xin.online_exam_sys.config.JWTConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JWTUtil {
    // 普通用户返回token
    public static String createAccessToken(String userId, String username) {
        // 登陆成功生成JWT
        String jwt = Jwts.builder()
                // 设置用户ID
                .setId(userId)
                // 设置用户名
                .setSubject(username)
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration * 1000))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JWTConfig.secret)
                .compact();
        // 添加到ThreadLocal线程池中，方便获取当前用户ID
        JWTContextUtil.setCurrentId(Long.valueOf(userId));
        // 返回jwt
        return jwt;
    }

    public static Claims getTokenClaim(String token) {
        return Jwts.parser()
                .setSigningKey(JWTConfig.secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
