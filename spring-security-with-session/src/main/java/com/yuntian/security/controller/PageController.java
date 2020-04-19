package com.yuntian.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @date 2020-04-16 23:33
 * @description
 */
@Controller
public class PageController {

    /**
     * 首页
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 首页
     */
    @RequestMapping("/index")
    public String indexPage() {
        return "index";
    }

    @PreAuthorize("hasAuthority(T(com.yuntian.security.config.security.AuthorityConstants).MENU_VIEW)")
    @RequestMapping("/menu")
    public String menuPage() {
        return "sys/menu";
    }

    @PreAuthorize("hasAuthority(T(com.yuntian.security.config.security.AuthorityConstants).USER_VIEW)")
    @RequestMapping("/user")
    public String userPage() {
        return "sys/user";
    }


    @RequestMapping("/login")
    public String loginPage() {
        return "auth/login";
    }


}
