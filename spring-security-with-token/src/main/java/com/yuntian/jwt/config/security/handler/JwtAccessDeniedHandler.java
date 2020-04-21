package com.yuntian.jwt.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.yuntian.jwt.common.ResultGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 403-页面资源授保护
 */
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(ResultGenerator.genFailResult(HttpStatus.FORBIDDEN.value(),"没有权限访问")));
        out.flush();
        out.close();
    }
}
