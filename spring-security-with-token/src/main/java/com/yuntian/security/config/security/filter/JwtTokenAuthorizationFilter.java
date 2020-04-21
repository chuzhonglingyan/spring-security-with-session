package com.yuntian.security.config.security.filter;

import com.yuntian.security.config.jwt.JwtProperties;
import com.yuntian.security.config.jwt.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author yuntian
 * @date 2020/3/5 0005 18:20
 * @description 身份认证接口-token认证
 */
public class JwtTokenAuthorizationFilter extends BasicAuthenticationFilter {

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private JwtUtil jwtUtil;

    public JwtTokenAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tokenHeader = request.getHeader(jwtProperties.getHeader());
        // 如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(jwtProperties.getTokenPrefix())) {
            chain.doFilter(request, response);
            return;
        }
        String token = tokenHeader.replace(jwtProperties.getTokenPrefix(), "");
        // 如果请求头中有token，则进行解析，并且设置认证信息
        if (SecurityContextHolder.getContext().getAuthentication() == null&&StringUtils.isNotBlank(token)) {
            String userName = getUsername(token);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, getAuthorities(token));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        super.doFilterInternal(request, response, chain);
    }

    private String getUsername(String token) {
        return (String) jwtUtil.getTokenClaim(token).get("userName");
    }

    private Collection<SimpleGrantedAuthority> getAuthorities(String token) {
        Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String> authorities = (List<String>) jwtUtil.getTokenClaim(token).get("authorityList");
        Objects.requireNonNull(authorities).forEach(authority -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        });
        return grantedAuthorities;
    }

}
