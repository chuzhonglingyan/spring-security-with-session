package com.yuntian.shrio.controller.sys;

import com.yuntian.shrio.model.entity.SysRole;
import com.yuntian.shrio.service.SysRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台系统-角色表(SysRole)表控制层
 *
 * @author makejava
 * @since 2020-04-19 10:52:15
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysRole selectOne(Long id) {
        return this.sysRoleService.queryById(id);
    }

}