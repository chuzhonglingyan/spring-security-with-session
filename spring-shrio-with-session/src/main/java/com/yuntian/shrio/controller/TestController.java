package com.yuntian.shrio.controller;

import com.yuntian.shrio.model.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping("/visit")
    public String visit(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.yuntian.com");
        return "views/guest";
    }

    @RequestMapping("/userList")
    public String userList(Model map) {
        UserInfo user = new UserInfo();
        user.setName("哈哈");
        List<UserInfo> userList=new ArrayList<>();;
        userList.add(user);
        map.addAttribute("userList", userList);
        map.addAttribute("user", user);
        return "user";
    }
}