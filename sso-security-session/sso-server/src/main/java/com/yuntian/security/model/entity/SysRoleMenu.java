package com.yuntian.security.model.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * 后台系统-角色菜单关系表(SysRoleMenu)实体类
 *
 * @author makejava
 * @since 2020-04-19 10:52:15
 */
@Data
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 813968815366610599L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 角色id
    */
    private Long roleId;
    /**
    * 菜单id
    */
    private Long menuId;
    /**
    * 菜单选择状态
    */
    private Integer isChecked;
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


}