package com.yuntian.shrio.common;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @date 2020-04-16 23:52
 * @description
 */
public abstract class BaseController {

    @Resource
    protected HttpServletRequest httpServletRequest;
}