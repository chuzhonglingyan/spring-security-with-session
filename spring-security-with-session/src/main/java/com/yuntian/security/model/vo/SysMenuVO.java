package com.yuntian.security.model.vo;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.yuntian.security.model.entity.SysMenu;

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