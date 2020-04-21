package com.yuntian.jwt.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.yuntian.jwt.common.ResultGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(ResultGenerator.genFailResult(HttpStatus.UNAUTHORIZED.value(),"未登录")));
        out.flush();
        out.close();
    }
}
