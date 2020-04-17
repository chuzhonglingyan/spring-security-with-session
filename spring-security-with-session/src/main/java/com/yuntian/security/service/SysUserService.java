package com.yuntian.security.service;

import com.yuntian.security.model.entity.UserInfo;

/**
 * @author Administrator
 * @date 2020-04-17 00:12
 * @description
 */
public interface SysUserService {

    UserInfo getUserByName(String userName);
}
