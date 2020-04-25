package com.yuntian.ssoserver.model.entity;

import lombok.Data;

/**
 * @author guangleilei.
 * @date Created in 17:27 2019/10/18
 * @description
 */
@Data
public class UserInfo {

    public UserInfo() {
    }

    public UserInfo(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    public UserInfo(Long id, String name, String password, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    private Long id;

    private String name;

    private String password;

    private Integer age;

    private String sex;


}
