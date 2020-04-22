package com.yuntian.shrio.controller;

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
        return "sys/index";
    }

    /**
     * 首页
     */
    @RequestMapping("/index")
    public String indexPage() {
        return "sys/index";
    }

    @RequestMapping("/menu")
    public String menuPage() {
        return "sys/menu";
    }

    @RequestMapping("/user")
    public String userPage() {
        return "sys/user";
    }


    @RequestMapping("/login")
    public String loginPage() {
        return "auth/login";
    }


}
