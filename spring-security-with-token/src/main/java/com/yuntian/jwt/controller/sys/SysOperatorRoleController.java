package com.yuntian.jwt.controller.sys;

import com.yuntian.jwt.model.entity.SysOperatorRole;
import com.yuntian.jwt.service.SysOperatorRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台系统-用户角色关系表(SysOperatorRole)表控制层
 *
 * @author makejava
 * @since 2020-04-19 10:52:14
 */
@RestController
@RequestMapping("sysOperatorRole")
public class SysOperatorRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysOperatorRoleService sysOperatorRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysOperatorRole selectOne(Long id) {
        return this.sysOperatorRoleService.queryById(id);
    }

}