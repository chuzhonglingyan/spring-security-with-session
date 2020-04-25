package com.yuntian.ssoclient1.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @Auther: yuntian
 * @Date: 2020/1/18 0018 13:05
 * @Description:
 */
@Configuration
@MapperScan("com.yuntian.ssoclient2.dao")
public class MyBatisConfig {


}