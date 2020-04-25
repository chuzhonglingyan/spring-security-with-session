package com.yuntian.ssoclient1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuntian
 * @date 2020/3/18 0018 00:01
 * @description
 */
@RestController
public class TestController {

    @GetMapping("/normal")
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    public String normal( ) {
        return "normal permission test success !!!";
    }

    @GetMapping("/medium")
    @PreAuthorize("hasAuthority('ROLE_MEDIUM')")
    public String medium() {
        return "medium permission test success !!!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin() {
        return "admin permission test success !!!";
    }
}