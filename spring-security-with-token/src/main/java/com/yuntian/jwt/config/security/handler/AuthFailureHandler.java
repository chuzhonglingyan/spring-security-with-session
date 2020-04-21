package com.yuntian.jwt.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.yuntian.jwt.common.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author guangleilei
 * @description 自定义失败处理器
 */
@Slf4j
public class AuthFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(ResultGenerator.genFailResult(e.getMessage())));
        out.flush();
        out.close();
        log.error("登录失败：" + "authentication failed, reason: " + e.getMessage());
    }
}
