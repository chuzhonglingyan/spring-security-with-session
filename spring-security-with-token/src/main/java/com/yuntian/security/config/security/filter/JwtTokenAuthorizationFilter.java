package com.yuntian.security.config.security.filter;

import com.yuntian.security.config.jwt.JwtProperties;
import com.yuntian.security.config.jwt.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
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
        if (StringUtils.isBlank(tokenHeader) || !tokenHeader.startsWith(jwtProperties.getTokenPrefix())) {
            throw new AuthenticationServiceException(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }
        String token = tokenHeader.replace(jwtProperties.getTokenPrefix(), "");
        if (jwtUtil.isTokenExpired(token)) {
            throw new AuthenticationServiceException(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }
        String userName = getUsername(token);
        if (StringUtils.isBlank(userName)) {
            throw new AuthenticationServiceException(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, getAuthorities(token));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }


    private String getUsername(String token) {
        return "";
    }

    private Collection<SimpleGrantedAuthority> getAuthorities(String token) {
        Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String> authorities = new ArrayList<>();
        Objects.requireNonNull(authorities).forEach(authority -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        });
        return null;
    }

}
