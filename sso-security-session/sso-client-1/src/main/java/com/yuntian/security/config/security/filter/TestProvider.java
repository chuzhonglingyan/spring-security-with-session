package com.yuntian.security.config.security.filter;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author Administrator
 * @date 2020-04-17 00:55
 * @description 默认实现：DaoAuthenticationProvider
 * additionalAuthenticationChecks方法校验密码有效性
 * retrieveUser方法根据用户名获取用户
 * createSuccessAuthentication完成授权持久化
 */
public class TestProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
