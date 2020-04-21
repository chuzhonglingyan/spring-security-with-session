package com.yuntian.jwt.config.security.handler;

import com.yuntian.jwt.config.jwt.JwtProperties;
import com.yuntian.jwt.config.redis.RedisManage;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.yuntian.jwt.config.redis.RedisKey.JWT_TOKEN_KEY;

/**
 * @author Administrator
 * @date 2020-04-21 23:37
 * @description
 */
public class ALogoutSuccessHandler implements LogoutSuccessHandler {
    @Resource
    private RedisManage redisManage;
    @Resource
    private JwtProperties jwtProperties;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String tokenHeader = request.getHeader(jwtProperties.getHeader());
        String token = tokenHeader.replace(jwtProperties.getTokenPrefix(), "");
        redisManage.del(JWT_TOKEN_KEY + token);
    }
}
