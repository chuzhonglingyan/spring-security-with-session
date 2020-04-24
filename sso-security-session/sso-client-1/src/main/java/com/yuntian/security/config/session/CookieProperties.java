package com.yuntian.security.config.session;

/**
 * @author yuntian
 * @date 2020/3/21 0021 00:08
 * @description
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix="spring.cookie")
@Data
public class CookieProperties {

    private Duration sessionTimeout;
    private Duration rememberMeTimeout;

}
