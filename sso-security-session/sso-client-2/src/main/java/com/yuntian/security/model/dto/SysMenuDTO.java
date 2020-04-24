package com.yuntian.security.model.dto;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.yuntian.security.model.entity.SysMenu;

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