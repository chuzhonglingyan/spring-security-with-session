package com.yuntian.jwt.model.vo;

import com.yuntian.jwt.model.entity.SysOperatorRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台系统-用户角色关系表(SysOperatorRole)VO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysOperatorRoleVO extends SysOperatorRole {
    private static final long serialVersionUID = -51730489088683274L;

}