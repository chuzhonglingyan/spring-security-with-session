package com.yuntian.shrio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @date 2020-04-19 21:42
 * @description
 */
@Controller
@RequestMapping("admin")
public class AdminController {


    @RequestMapping("index")
    public String index() {
        return "sys/admin";
    }


}
