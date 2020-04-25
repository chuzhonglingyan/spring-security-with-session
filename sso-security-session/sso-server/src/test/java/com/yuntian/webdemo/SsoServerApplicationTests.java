package com.yuntian.webdemo;

import com.yuntian.ssoserver.SsoServerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest(classes= SsoServerApplication.class)
class SsoServerApplicationTests {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        log.info(passwordEncoder.encode("123456"));
    }

}
