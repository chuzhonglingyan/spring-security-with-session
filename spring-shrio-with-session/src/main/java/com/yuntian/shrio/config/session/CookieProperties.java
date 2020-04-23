package com.yuntian.shrio.config.session;

/**
 * @author yuntian
 * @date 2020/3/21 0021 00:08
 * @description
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@ConfigurationProperties(prefix="spring.cookie")
@Data
public class CookieProperties {

    private Duration sessionTimeout;
    private Duration rememberMeTimeout;
    private String rememberMeCipherKey;

}
