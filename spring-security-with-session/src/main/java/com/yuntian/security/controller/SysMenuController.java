package com.yuntian.security.controller;

import com.yuntian.security.model.entity.SysMenu;
import com.yuntian.security.service.SysMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台系统-菜单表(SysMenu)表控制层
 *
 * @author makejava
 * @since 2020-04-19 10:52:10
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysMenu selectOne(Long id) {
        return this.sysMenuService.queryById(id);
    }

}