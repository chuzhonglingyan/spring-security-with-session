package com.yuntian.security.controller;

import org.springframework.security.access.annotation.Secured;
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

    @Secured(value = "menu:list")
    @RequestMapping("/menu")
    public String menuPage() {
        return "sys/menu";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "auth/login";
    }


}
