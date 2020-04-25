package com.yuntian.ssoserver.controller.sys;

import com.yuntian.ssoserver.service.SysRoleMenuService;
import com.yuntian.ssoserver.model.entity.SysRoleMenu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 后台系统-角色菜单关系表(SysRoleMenu)表控制层
 *
 * @author makejava
 * @since 2020-04-19 10:52:15
 */
@RestController
@RequestMapping("sysRoleMenu")
public class SysRoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysRoleMenu selectOne(Long id) {
        return this.sysRoleMenuService.queryById(id);
    }

}