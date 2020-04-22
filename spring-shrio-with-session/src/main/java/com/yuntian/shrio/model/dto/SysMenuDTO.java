package com.yuntian.shrio.model.dto;

import com.yuntian.shrio.model.entity.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台系统-菜单表(SysMenu)DTO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenuDTO extends SysMenu {
    private static final long serialVersionUID = -87528239977191294L;


}