package com.yuntian.shrio.controller.sys;


import com.yuntian.shrio.common.Result;
import com.yuntian.shrio.common.ResultGenerator;
import com.yuntian.shrio.model.dto.SysMenuDTO;
import com.yuntian.shrio.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 后台系统-菜单表(SysMenu)表控制层
 *
 * @author makejava
 * @since 2020-04-19 10:52:10
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    @RequestMapping("add")
    public Result add(SysMenuDTO dto) {
        return ResultGenerator.genSuccessResult();
    }


}