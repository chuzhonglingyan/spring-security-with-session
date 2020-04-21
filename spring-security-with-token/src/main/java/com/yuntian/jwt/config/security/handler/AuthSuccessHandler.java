package com.yuntian.jwt.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuntian.jwt.common.ResultGenerator;
import com.yuntian.jwt.config.jwt.JwtProperties;
import com.yuntian.jwt.config.jwt.JwtUtil;
import com.yuntian.jwt.config.redis.RedisManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.yuntian.jwt.config.redis.RedisKey.JWT_TOKEN_KEY;

/**
 * @author guangleilei
 * @description 自定义成功处理器
 */
@Slf4j
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private RedisManage redisManage;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails jwtUser = (UserDetails) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        List<String> authorityList = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        Map<String, Object> param = new HashMap<>();
        param.put("userName", jwtUser.getUsername());
        param.put("authorityList", authorityList);
        String token = jwtUtil.createToken(jwtUser.getUsername(), param);
        redisManage.set(JWT_TOKEN_KEY+token,token,jwtProperties.getExpire());
        // 但是这里创建的token只是单纯的token,按照jwt的规定，最后请求的格式应该是 `Bearer token`
        response.setHeader(jwtProperties.getHeader(), jwtProperties.getTokenPrefix() + token);
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        PrintWriter out = response.getWriter();
        out.write(JSONObject.toJSONString(ResultGenerator.genSuccessResult()));
        out.flush();
        out.close();
        log.info("登录成功：" + JSON.toJSONString(authentication));
    }
}
