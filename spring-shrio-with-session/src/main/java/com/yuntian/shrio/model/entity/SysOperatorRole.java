package com.yuntian.shrio.model.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * 后台系统-用户角色关系表(SysOperatorRole)实体类
 *
 * @author makejava
 * @since 2020-04-19 10:52:14
 */
@Data
public class SysOperatorRole implements Serializable {
    private static final long serialVersionUID = -97705222344904681L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 角色id
    */
    private Long roleId;
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