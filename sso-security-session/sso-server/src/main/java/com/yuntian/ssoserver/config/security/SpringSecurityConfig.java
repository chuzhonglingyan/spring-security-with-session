package com.yuntian.ssoserver.config.security;

import com.yuntian.ssoserver.config.security.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yuntian
 * @date 2020/3/17 0017 23:54
 * @description
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.requestMatchers()
                .antMatchers("/oauth/**", "/login/**", "/logout/**","/custom/confirm_access")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**")
                .authenticated()
                .and()
                .formLogin().loginPage("/oauth/index")
                .loginProcessingUrl("/oauth/login").permitAll();
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
    public UserDetailsService userDetailService() {
        return new UserDetailServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}