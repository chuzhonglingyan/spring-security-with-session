package com.yuntian.security.service.impl;

import com.yuntian.security.model.entity.UserInfo;
import com.yuntian.security.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * @date 2020-04-17 00:14
 * @description
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    static Map<String, UserInfo> userInfoMap=new ConcurrentHashMap<>();
    static {
        UserInfo userInfo=new UserInfo();
        userInfo.setName("admin");
        userInfo.setId(1L);
        userInfo.setPassword("123456");

        UserInfo userInfo2=new UserInfo();
        userInfo.setName("test");
        userInfo.setId(1L);
        userInfo.setPassword("123456");
        userInfoMap.put("admin",userInfo);
        userInfoMap.put("test",userInfo2);
    }
    @Override
    public UserInfo getUserByName(String userName) {
        return  userInfoMap.get(userName);
    }
}
