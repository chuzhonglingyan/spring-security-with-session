package com.yuntian.shrio.config.shiro;

import com.yuntian.shrio.model.entity.SysOperator;
import com.yuntian.shrio.service.SysOperatorService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ShiroRealm extends SimpleAccountRealm {

    @Resource
    private SysOperatorService sysOperatorService;

    @Override
    protected AuthenticationInfo  doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) authenticationToken.getPrincipal();
        SysOperator userInfo = sysOperatorService.getByUserName(userName);
        if (userInfo == null) {
            throw new UnknownAccountException();
        }
        String salt = userInfo.getSalt();
        return new SimpleAuthenticationInfo(userName, userInfo.getPassWord(), ByteSource.Util.bytes(salt), getName());
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
