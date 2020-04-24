package com.yuntian.jwt.config.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Component
public class JwtUser {

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private JwtProperties jwtProperties;

    public void  saveUserInfo(){

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

   public Claims  getClaimsByToken(String tokenHeader){
       if (tokenHeader == null || !tokenHeader.startsWith(jwtProperties.getTokenPrefix())) {
           return null;
       }
       String token = tokenHeader.replace(jwtProperties.getTokenPrefix(), "");
       Claims claims = jwtUtil.getTokenClaim(token);
       if (claims == null) {
           return null;
       }
       if (jwtUtil.isTokenExpired(claims)) {
           return null;
       }
       return  claims;
   }


}
