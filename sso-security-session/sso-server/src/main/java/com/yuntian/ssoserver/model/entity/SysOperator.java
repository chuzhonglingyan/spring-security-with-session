package com.yuntian.ssoserver.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台系统-用户表(SysOperator)实体类
 *
 * @author makejava
 * @since 2020-04-19 10:52:10
 */
@Data
public class SysOperator implements Serializable {
    private static final long serialVersionUID = -67451368993854383L;
    
    private Long id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 昵称
    */
    private String nickName;
    /**
    * 密码
    */
    private String passWord;
    /**
    * 0-男，1-女，默认为0
    */
    private Integer sex;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 电话
    */
    private String phone;
    /**
    * 用户状态 0-禁用 ,1-启用  默认为0 
    */
    private Integer status;
    /**
    * 是否超管  0-否，1-是，默认为0
    */
    private Integer isSupper;
    /**
    * 创建人
    */
    private Long createId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新人
    */
    private Long updateId;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 是否删除，0-未删除，1-删除，默认为0
    */
    private Integer isDelete;


}