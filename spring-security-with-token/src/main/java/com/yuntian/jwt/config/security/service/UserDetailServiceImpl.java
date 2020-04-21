package com.yuntian.jwt.config.security.service;

import com.yuntian.jwt.model.entity.SysOperator;
import com.yuntian.jwt.service.SysMenuService;
import com.yuntian.jwt.service.SysOperatorService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2020-04-16 23:28
 * @description authenticate方法传入前端字段，loadUserByUsername方法塞入数据库字段
 * DaoAuthenticationProvider进行校验
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private SysOperatorService sysOperatorService;

    @Resource
    private SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysOperator userInfo = sysOperatorService.getByUserName(username);
        if (userInfo == null) {
            throw new BadCredentialsException("该用户不存在");
        }
        //此处可以验证用户的状态 比如锁定
        List<String> menuList = sysMenuService.getMenuListByUserId(userInfo.getId());
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        //hasRole("LEVEL1")判断时会自动加上ROLE_前缀变成 ROLE_LEVEL1
        if (menuList != null && menuList.size() > 0) {
            grantedAuthorityList = menuList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }
        //当认证成功后，UserDetails将被用户构建Authentication对象，存储在SecurityContextHolder中。
        return new User(username, userInfo.getPassWord(), grantedAuthorityList);
    }


}
