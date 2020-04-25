package com.yuntian.ssoserver.model.vo;

import com.yuntian.ssoserver.model.entity.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台系统-菜单表(SysMenu)VO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenuVO extends SysMenu {
    private static final long serialVersionUID = 751607582716295260L;

}