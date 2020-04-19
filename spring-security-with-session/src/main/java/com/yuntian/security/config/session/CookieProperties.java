package com.yuntian.security.config.session;

/**
 * @author yuntian
 * @date 2020/3/21 0021 00:08
 * @description
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * prefix="com.whx.blog" ：
 * 在application.properties配置的属性前缀，
 * 在类中的属性就不用使用{@value}进行注入了。
 * @author Administrator
 */
@ConfigurationProperties(prefix="spring.session.cookie")
@Data
public class CookieProperties {

    private Duration timeout;

}
