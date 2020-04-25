package com.yuntian.ssoserver.model.vo;

import com.yuntian.ssoserver.model.entity.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台系统-角色表(SysRole)VO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleVO extends SysRole {
    private static final long serialVersionUID = 436647117918928653L;

}