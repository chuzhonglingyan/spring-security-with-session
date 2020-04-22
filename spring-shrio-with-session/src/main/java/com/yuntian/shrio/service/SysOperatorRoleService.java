package com.yuntian.shrio.service;

import com.yuntian.shrio.model.entity.SysOperatorRole;

import java.util.List;

/**
 * 后台系统-用户角色关系表(SysOperatorRole)表服务接口
 *
 * @author makejava
 * @since 2020-04-19 10:52:14
 */
public interface SysOperatorRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOperatorRole queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOperatorRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysOperatorRole 实例对象
     * @return 实例对象
     */
    SysOperatorRole insert(SysOperatorRole sysOperatorRole);

    /**
     * 修改数据
     *
     * @param sysOperatorRole 实例对象
     * @return 实例对象
     */
    SysOperatorRole update(SysOperatorRole sysOperatorRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}