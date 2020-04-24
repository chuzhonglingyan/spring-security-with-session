package com.yuntian.webdemo;

import com.yuntian.security.SpringSecurityDemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest(classes= SpringSecurityDemoApplication.class)
class SpringSecurityDemoApplicationTests {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        log.info(passwordEncoder.encode("123456"));
    }

}
