package com.yuntian.security.service;

import com.yuntian.security.model.entity.Role;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-17 00:18
 * @description
 */
public interface SysRoleService {


    List<String> getRoleListByUserId(Long userId);
}
