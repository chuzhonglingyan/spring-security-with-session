package com.yuntian.shrio.config;

import com.yuntian.shrio.model.entity.SysOperator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author Administrator
 * @date 2020-04-25 17:26
 * @description
 */
public class SubjectUtil {

    public static SysOperator getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        return (SysOperator) subject.getPrincipal();
    }

    public static String getUserName() {
        Subject subject = SecurityUtils.getSubject();
        SysOperator userInfo = (SysOperator) subject.getPrincipal();
        return userInfo.getUserName();
    }

}
