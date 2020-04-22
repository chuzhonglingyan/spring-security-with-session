package com.yuntian.jwt.config.security.filter;

import com.yuntian.jwt.config.jwt.JwtProperties;
import com.yuntian.jwt.config.jwt.JwtUtil;
import com.yuntian.jwt.config.redis.RedisManage;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

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

import static com.yuntian.jwt.config.redis.RedisKey.JWT_TOKEN_KEY;

/**
 * @author yuntian
 * @date 2020/3/5 0005 18:20
 * @description 身份认证接口-token认证 https://www.jianshu.com/p/2f8b6591a09d
 */
public class JwtTokenAuthorizationFilter extends BasicAuthenticationFilter {

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private RedisManage redisManage;


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
        Claims claims = jwtUtil.getTokenClaim(token);
        if (claims == null) {
            chain.doFilter(request, response);
            return;
        }
        if (jwtUtil.isTokenExpired(claims)) {
            chain.doFilter(request, response);
            return;
        }
        String tokenRedis = redisManage.getValue(JWT_TOKEN_KEY + token);
        if (StringUtils.isEmpty(tokenRedis)) {
            chain.doFilter(request, response);
            return;
        }

        // 如果请求头中有token，则进行解析，并且设置认证信息
        String userName = getUsername(claims);
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, getAuthorities(claims));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        super.doFilterInternal(request, response, chain);
    }

    private String getUsername(Claims claims) {
        return (String) claims.get("userName");
    }

    private Collection<SimpleGrantedAuthority> getAuthorities(Claims claims) {
        Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String> authorities = (List<String>) claims.get("authorityList");
        Objects.requireNonNull(authorities).forEach(authority -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        });
        return grantedAuthorities;
    }

}
