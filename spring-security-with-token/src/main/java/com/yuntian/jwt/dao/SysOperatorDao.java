package com.yuntian.jwt.dao;

import com.yuntian.jwt.model.entity.SysOperator;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 后台系统-用户表(SysOperator)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-19 10:52:10
 */
public interface SysOperatorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOperator queryById(Long id);

    /**
     * 通过ID查询单条数据
     *
     * @param userNme 主键
     * @return 实例对象
     */
    SysOperator queryByUserNme(String userNme);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOperator> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysOperator 实例对象
     * @return 对象列表
     */
    List<SysOperator> queryAll(SysOperator sysOperator);

    /**
     * 新增数据
     *
     * @param sysOperator 实例对象
     * @return 影响行数
     */
    int insert(SysOperator sysOperator);

    /**
     * 修改数据
     *
     * @param sysOperator 实例对象
     * @return 影响行数
     */
    int update(SysOperator sysOperator);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}