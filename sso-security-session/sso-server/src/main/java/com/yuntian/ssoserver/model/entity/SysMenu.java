package com.yuntian.ssoserver.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台系统-菜单表(SysMenu)实体类
 *
 * @author makejava
 * @since 2020-04-19 10:52:08
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = -20090771686495682L;
    /**
    * 菜单id
    */
    private Long id;
    /**
    * 父菜单id
    */
    private Long pid;
    /**
    * 菜单名称
    */
    private String name;
    /**
    * 菜单路径
    */
    private String path;
    /**
    * 菜单类型，0：根目录,1：菜单，2：操作
    */
    private Integer type;
    /**
    * 菜单等级 1一级菜单  2 二级菜单  3 三级菜单
    */
    private Integer level;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 组件
    */
    private String component;
    /**
    * 组件名称
    */
    private String componentName;
    /**
    * 授权(多个用逗号分隔，如：user:list,user:add)
    */
    private String permission;
    /**
    * 图标
    */
    private String icon;
    /**
    * 是否可见  0-否,1-是  默认0
    */
    private Integer visible;
    /**
    * 是否缓存  0-否,1-是  默认0
    */
    private Integer cache;
    /**
    * 菜单状态  0-禁用 ,1-启用  默认为0 
    */
    private Integer status;
    /**
    * 是否外链 0：否,1：是
    */
    private Integer isLinked;
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