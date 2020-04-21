package com.yuntian.jwt.controller.sys;

import com.yuntian.jwt.model.entity.SysRoleMenu;
import com.yuntian.jwt.service.SysRoleMenuService;
import org.springframework.web.bind.annotation.*;

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