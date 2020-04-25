package com.yuntian.ssoserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 * @date 2020-04-25 02:05
 * @description 登录认证页面
 */
@Controller
@RequestMapping("oauth")
public class AuthenticationController {

    @RequestMapping("/index")
    public ModelAndView loginPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("auth/login");
        view.addObject("loginAction","/oauth/login");
        return view;
    }

}
