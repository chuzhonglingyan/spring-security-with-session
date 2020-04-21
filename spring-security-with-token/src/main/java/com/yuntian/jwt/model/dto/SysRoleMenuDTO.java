package com.yuntian.jwt.model.dto;

import com.yuntian.jwt.model.entity.SysRoleMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台系统-角色菜单关系表(SysRoleMenu)DTO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenuDTO extends SysRoleMenu {
    private static final long serialVersionUID = 911589440199876204L;


}