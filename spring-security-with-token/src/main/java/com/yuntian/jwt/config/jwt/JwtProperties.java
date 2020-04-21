package com.yuntian.jwt.config.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("jwt")
public class JwtProperties {

    private String secret;
    private long expire;
    private String header;
    private String tokenPrefix;

    public String getTokenPrefix() {
        return tokenPrefix+" ";
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }
}
