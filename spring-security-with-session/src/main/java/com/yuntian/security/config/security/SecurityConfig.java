package com.yuntian.security.config.security;

import com.yuntian.security.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * EnableWebSecurity注解使得SpringMVC集成了Spring Security的web安全支持
 * @author guangleilei
 */
@EnableWebSecurity
@EnableRedisHttpSession
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则
        http.authorizeRequests()
                .antMatchers("/favicon.ico", "/static/**", "/login", "/auth/login")
                .permitAll()
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("login");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("rememberMe");
        //最大session并发数量1
        http.sessionManagement().maximumSessions(1);
    }

    /**
     * 自定义认证数据源
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailServiceImpl userDetailService() {
        return new UserDetailServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}