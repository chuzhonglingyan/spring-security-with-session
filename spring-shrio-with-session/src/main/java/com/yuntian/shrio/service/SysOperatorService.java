package com.yuntian.shrio.service;

import com.yuntian.shrio.model.entity.SysOperator;

import java.util.List;

/**
 * 后台系统-用户表(SysOperator)表服务接口
 *
 * @author makejava
 * @since 2020-04-19 10:52:11
 */
public interface SysOperatorService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOperator queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOperator> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysOperator 实例对象
     * @return 实例对象
     */
    SysOperator insert(SysOperator sysOperator);

    /**
     * 修改数据
     *
     * @param sysOperator 实例对象
     * @return 实例对象
     */
    SysOperator update(SysOperator sysOperator);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    SysOperator  getByUserName(String name);

}