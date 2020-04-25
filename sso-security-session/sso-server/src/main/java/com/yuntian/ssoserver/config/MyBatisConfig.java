package com.yuntian.ssoserver.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @Auther: yuntian
 * @Date: 2020/1/18 0018 13:05
 * @Description:
 */
@Configuration
@MapperScan("com.yuntian.ssoserver.dao")
public class MyBatisConfig {


}