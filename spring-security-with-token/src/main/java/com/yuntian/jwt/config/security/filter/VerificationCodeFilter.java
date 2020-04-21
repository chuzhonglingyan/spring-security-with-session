package com.yuntian.jwt.config.security.filter;

/**
 * @author Administrator
 * @date 2020-04-19 11:49
 * @description
 */

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * 验证码验证
 */
public class VerificationCodeFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler failureHandler;

    public VerificationCodeFilter(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException, ServletException {
        // 登录请求不校验验证码
        if (Objects.equals(request.getRequestURI(), "/login")) {
            String captcha = request.getParameter("captcha");
            HttpSession session = request.getSession();
            String expect = (String) session.getAttribute("captcha");
            if (!StringUtils.isEmpty(expect)) {
                // 随手清除验证码，无论是失败，还是成功。客户端应在登录失败时刷新验证码
                session.removeAttribute("captcha");
            }
            if (!Objects.equals(captcha, expect)) {
                failureHandler.onAuthenticationFailure(request, response, new AuthenticationServiceException("验证码错误!"));
            } else {
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
