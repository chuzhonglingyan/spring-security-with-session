package com.yuntian.ssoserver.model.dto;

import com.yuntian.ssoserver.model.entity.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台系统-角色表(SysRole)DTO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleDTO extends SysRole {
    private static final long serialVersionUID = 334529739863628010L;


}