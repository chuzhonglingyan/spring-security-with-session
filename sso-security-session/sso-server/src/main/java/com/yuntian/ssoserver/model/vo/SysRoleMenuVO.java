package com.yuntian.ssoserver.model.vo;

import com.yuntian.ssoserver.model.entity.SysRoleMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台系统-角色菜单关系表(SysRoleMenu)VO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenuVO extends SysRoleMenu {
    private static final long serialVersionUID = 557831418989594025L;

}