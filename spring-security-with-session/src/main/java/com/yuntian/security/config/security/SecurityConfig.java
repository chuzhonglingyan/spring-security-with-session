package com.yuntian.security.config.security;

import com.yuntian.security.config.security.filter.LoginAuthenticationFilter;
import com.yuntian.security.config.security.handler.AuthFailureHandler;
import com.yuntian.security.config.security.handler.AuthSuccessHandler;
import com.yuntian.security.config.security.service.UserDetailServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * EnableWebSecurity注解使得SpringMVC集成了Spring Security的web安全支持
 *
 * @author guangleilei
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则
        http.csrf().disable().formLogin().loginPage("/login").loginProcessingUrl("/auth/login");
        http.authorizeRequests()
                .antMatchers("/favicon.ico", "/static/**", "/login", "/auth/login")
                .permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(loginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    LoginAuthenticationFilter loginAuthenticationFilter() throws Exception {
        LoginAuthenticationFilter loginAuthenticationFilter = new LoginAuthenticationFilter();
        loginAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        loginAuthenticationFilter.setAuthenticationSuccessHandler(new AuthSuccessHandler());
        loginAuthenticationFilter.setAuthenticationFailureHandler(new AuthFailureHandler());
        return loginAuthenticationFilter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @ConditionalOnMissingBean(ClassPathTldsLoader.class)
    public ClassPathTldsLoader classPathTldsLoader(){
        return new ClassPathTldsLoader();
    }
}