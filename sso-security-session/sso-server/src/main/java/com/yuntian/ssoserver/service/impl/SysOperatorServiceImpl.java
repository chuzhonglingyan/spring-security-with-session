package com.yuntian.ssoserver.service.impl;

import com.yuntian.ssoserver.dao.SysOperatorDao;
import com.yuntian.ssoserver.service.SysOperatorService;
import com.yuntian.ssoserver.model.entity.SysOperator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台系统-用户表(SysOperator)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 10:52:11
 */
@Service("sysOperatorService")
public class SysOperatorServiceImpl implements SysOperatorService {
    @Resource
    private SysOperatorDao sysOperatorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysOperator queryById(Long id) {
        return this.sysOperatorDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysOperator> queryAllByLimit(int offset, int limit) {
        return this.sysOperatorDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysOperator 实例对象
     * @return 实例对象
     */
    @Override
    public SysOperator insert(SysOperator sysOperator) {
        this.sysOperatorDao.insert(sysOperator);
        return sysOperator;
    }

    /**
     * 修改数据
     *
     * @param sysOperator 实例对象
     * @return 实例对象
     */
    @Override
    public SysOperator update(SysOperator sysOperator) {
        this.sysOperatorDao.update(sysOperator);
        return this.queryById(sysOperator.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysOperatorDao.deleteById(id) > 0;
    }

    @Override
    public SysOperator getByUserName(String name) {
        return sysOperatorDao.queryByUserNme(name);
    }
}