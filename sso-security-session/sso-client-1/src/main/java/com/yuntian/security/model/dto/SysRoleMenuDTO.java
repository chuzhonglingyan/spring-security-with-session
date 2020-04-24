package com.yuntian.security.model.dto;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.yuntian.security.model.entity.SysRoleMenu;

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