package com.yuntian.shrio.model.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * 后台系统-角色表(SysRole)实体类
 *
 * @author makejava
 * @since 2020-04-19 10:52:14
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = -96515861225806531L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 角色key
    */
    private String roleKey;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 级别
    */
    private Integer level;
    /**
    * 角色状态  0-禁用 ,1-启用  默认为0 
    */
    private Integer status;
    /**
    * 备注
    */
    private String remark;
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