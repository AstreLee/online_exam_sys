package com.xin.online_exam_sys.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTConfig {
    /**
     * 密钥KEY
     */
    public static String secret;
    /**
     * TokenKey
     */
    public static String tokenHeader;
    /**
     * 过期时间
     */
    public static Integer expiration;

    public void setSecret(String secret) {
        JWTConfig.secret = secret;
    }

    public void setTokenHeader(String tokenHeader) {
        JWTConfig.tokenHeader = tokenHeader;
    }

    public void setExpiration(Integer expiration) {
        JWTConfig.expiration = expiration;
    }
}
