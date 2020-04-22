package com.yuntian.webdemo;

import com.yuntian.shrio.SpringShrioDemoApplication;
import com.yuntian.shrio.config.shiro.ShrioHashUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@Slf4j
@SpringBootTest(classes = SpringShrioDemoApplication.class)
class SpringShrioDemoApplicationTests {


    @Resource
    private ShrioHashUtil shrioHashUtil;

    @Test
    void contextLoads() {
        String pwd="123456";
        String salt=shrioHashUtil.createSalt();
        String passWordStr= shrioHashUtil.hashPassWordStr(pwd,salt);
        log.info("盐："+salt);
        log.info("hash密码："+passWordStr);
        log.info("比较密码:"+shrioHashUtil.passwordsMatch(pwd,salt,passWordStr));
    }

}
