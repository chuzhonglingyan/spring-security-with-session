package com.yuntian.shrio.common;


import com.yuntian.shrio.config.SubjectUtil;
import com.yuntian.shrio.model.entity.SysOperator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

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

    public SysOperator getUserInfo() {
        return SubjectUtil.getUserInfo();
    }

}
