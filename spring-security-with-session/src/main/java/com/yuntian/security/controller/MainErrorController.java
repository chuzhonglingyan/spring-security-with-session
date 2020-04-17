package com.yuntian.security.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：guangleilei.
 * @ Date       ：Created in 14:10 2018/11/13
 * @ Description：${自定义错误页面}
 * @author guangleilei
 */
@Controller
public class MainErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(PATH)
    public String handleError(HttpServletRequest request) { //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 401) {
            return "error/401";
        } else if (statusCode == 404) {
            return "error/404";
        } else if (statusCode == 403) {
            return "error/403";
        } else {
            return "error/500";
        }
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}
