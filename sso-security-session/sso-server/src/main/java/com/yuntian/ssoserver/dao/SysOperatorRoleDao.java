package com.yuntian.ssoserver.dao;

import com.yuntian.ssoserver.model.entity.SysOperatorRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台系统-用户角色关系表(SysOperatorRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-19 10:52:14
 */
public interface SysOperatorRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOperatorRole queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOperatorRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysOperatorRole 实例对象
     * @return 对象列表
     */
    List<SysOperatorRole> queryAll(SysOperatorRole sysOperatorRole);

    /**
     * 新增数据
     *
     * @param sysOperatorRole 实例对象
     * @return 影响行数
     */
    int insert(SysOperatorRole sysOperatorRole);

    /**
     * 修改数据
     *
     * @param sysOperatorRole 实例对象
     * @return 影响行数
     */
    int update(SysOperatorRole sysOperatorRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}