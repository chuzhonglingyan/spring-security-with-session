package com.yuntian.security.controller;

import com.yuntian.security.common.BaseController;
import com.yuntian.security.common.Result;
import com.yuntian.security.config.security.SecurityUtils;
import com.yuntian.security.model.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author yuntian
 * @date 2020/3/18 0018 23:06
 * @description 手动认证-自定义接口
 */
@RestController("auth")
public class AuthController extends BaseController {

    @Resource
    private AuthenticationManager myAuthenticationManager;

    @RequestMapping(value = "login")
    public Result login(UserDto userDto) {
        //验证登录成功
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword());
        Authentication authenticate = myAuthenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //登录成功,手动维持会话
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        return new Result();
    }

    @RequestMapping(value = "register")
    public Result register(UserDto userDto) {
        return new Result();
    }

    @RequestMapping(value = "loginOut")
    public Result loginOut(UserDto userDto) {
        SecurityUtils.logout();
        return new Result();
    }

    /**
     * 获取认证信息
     * @param user
     * @return
     */
    @GetMapping("/authentication")
    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return user;
    }


}
