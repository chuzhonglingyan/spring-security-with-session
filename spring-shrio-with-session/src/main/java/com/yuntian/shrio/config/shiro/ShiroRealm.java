package com.yuntian.shrio.config.shiro;

import com.yuntian.shrio.model.entity.SysOperator;
import com.yuntian.shrio.service.SysMenuService;
import com.yuntian.shrio.service.SysOperatorService;
import com.yuntian.shrio.service.SysRoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SysOperatorService sysOperatorService;
    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private SysRoleService sysRoleService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        SysOperator userInfo = sysOperatorService.getByUserName(userName);
        if (userInfo == null) {
            throw new UnknownAccountException();
        }
        String salt = userInfo.getSalt();
        return new SimpleAuthenticationInfo(userName, userInfo.getPassWord(), ByteSource.Util.bytes(salt), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userName = (String) principalCollection.getPrimaryPrincipal();
        List<String> menuList = sysMenuService.getMenuListByUserName(userName);
        List<String> roleList = sysRoleService.getListByUserName(userName);
        authorizationInfo.setRoles(new HashSet<>(roleList));
        authorizationInfo.setStringPermissions(new HashSet<>(menuList));
        return authorizationInfo;
    }

}
