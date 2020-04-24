package com.yuntian.security.controller.sys;

import com.yuntian.security.model.entity.SysOperator;
import com.yuntian.security.service.SysOperatorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台系统-用户表(SysOperator)表控制层
 *
 * @author makejava
 * @since 2020-04-19 10:52:12
 */
@RestController
@RequestMapping("sysOperator")
public class SysOperatorController {
    /**
     * 服务对象
     */
    @Resource
    private SysOperatorService sysOperatorService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysOperator selectOne(Long id) {
        return this.sysOperatorService.queryById(id);
    }

}