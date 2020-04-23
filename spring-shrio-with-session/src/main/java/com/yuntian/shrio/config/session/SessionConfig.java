package com.yuntian.shrio.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2020-04-19 22:18
 * @description
 */
@Configuration
public class SessionConfig {

    @Resource
    private  CookieProperties cookieProperties;

    @Bean
    CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("SESSION");
        serializer.setCookieMaxAge((int) cookieProperties.getSessionTimeout().getSeconds());
        //这样域名相同,同根下的所有web应用就可以轻松实现单点登录共享session
        serializer.setCookiePath("/");
        return serializer;
    }
}
