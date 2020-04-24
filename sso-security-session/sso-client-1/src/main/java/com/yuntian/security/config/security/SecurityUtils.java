package com.yuntian.security.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @author Administrator
 * @date 2020-04-16 23:44
 * @description 手动去认证-授权
 */
public class SecurityUtils {

    public static User getUser() {
        Authentication authentication = getAuthentication();
        return (User) authentication.getPrincipal();
    }


    public static Collection<? extends GrantedAuthority> getAllPermission() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities();
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static boolean hasPermission(String permission) {
        if (StringUtils.isEmpty(permission)) {
            return false;
        }
        Collection<? extends GrantedAuthority> authorities = getAllPermission();
        boolean hasPermission = false;
        for (GrantedAuthority grantedAuthority : authorities) {
            String authority = grantedAuthority.getAuthority();
            if (authority.equals(permission)) {
                hasPermission = true;
            }
        }
        return hasPermission;
    }

    public static void logout() {
        SecurityContextHolder.clearContext();
    }

}