package com.yuntian.shrio.controller.auth;

import com.yuntian.shrio.common.BaseController;
import com.yuntian.shrio.common.Result;
import com.yuntian.shrio.common.ResultGenerator;
import com.yuntian.shrio.config.shiro.ShiroRealm;
import com.yuntian.shrio.model.dto.SysOperatorDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yuntian
 * @date 2020/3/18 0018 23:06
 * @description 手动认证-自定义接口
 */
@RestController
@RequestMapping("auth")
public class AuthController extends BaseController {


    @RequestMapping(value = "login")
    public Result login(SysOperatorDTO dto) {
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getUserName(), dto.getPassWord(), dto.isRememberMe());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "register")
    public Result register(SysOperatorDTO dto) {
        return new Result();
    }

    @RequestMapping(value = "logout")
    public Result loginOut(SysOperatorDTO dto) {
        SecurityUtils.getSubject().logout();
        return ResultGenerator.genSuccessResult();
    }

    @Resource
    private ShiroRealm shiroRealm;

    @RequestMapping(value = "getAuthorizationInfo")
    public Result getAuthorizationInfo(SysOperatorDTO dto) {
        AuthorizationInfo authorizationInfo = shiroRealm.getAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
        return ResultGenerator.genSuccessResult(authorizationInfo);
    }

    @RequestMapping(value = "updateAuthorizationInfo")
    public Result updateAuthorizationInfo(SysOperatorDTO dto) {
        shiroRealm.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
        return ResultGenerator.genSuccessResult();
    }

}
