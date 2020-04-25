package com.yuntian.ssoserver.controller.sys;

import com.yuntian.ssoserver.service.SysOperatorService;
import com.yuntian.ssoserver.model.entity.SysOperator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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