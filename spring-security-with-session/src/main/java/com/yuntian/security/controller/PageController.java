package com.yuntian.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String index (){
        return "index" ;
    }

    /**
     * 首页
     */
    @RequestMapping("/index")
    public String indexPage(){
        return "index" ;
    }


    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String loginPage (){
        return "login" ;
    }
    /**
     * page1 下页面
     */
    @PreAuthorize("hasAuthority('LEVEL1')")
    @RequestMapping("/page1/{pageName}")
    public String onePage (@PathVariable("pageName") String pageName){
        return "pages/page1/"+pageName ;
    }
    /**
     * page2 下页面
     */
    @PreAuthorize("hasAuthority('LEVEL2')")
    @RequestMapping("/page2/{pageName}")
    public String twoPage (@PathVariable("pageName") String pageName){
        return "pages/page2/"+pageName ;
    }
    /**
     * page3 下页面
     */
    @PreAuthorize("hasAuthority('LEVEL3')")
    @RequestMapping("/page3/{pageName}")
    public String threePage (@PathVariable("pageName") String pageName){
        return "pages/page3/"+pageName ;
    }


}
