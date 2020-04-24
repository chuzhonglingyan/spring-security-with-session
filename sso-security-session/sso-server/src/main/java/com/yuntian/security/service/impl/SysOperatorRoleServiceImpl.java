package com.yuntian.security.service.impl;

import com.yuntian.security.model.entity.SysOperatorRole;
import com.yuntian.security.dao.SysOperatorRoleDao;
import com.yuntian.security.service.SysOperatorRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台系统-用户角色关系表(SysOperatorRole)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 10:52:14
 */
@Service("sysOperatorRoleService")
public class SysOperatorRoleServiceImpl implements SysOperatorRoleService {
    @Resource
    private SysOperatorRoleDao sysOperatorRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysOperatorRole queryById(Long id) {
        return this.sysOperatorRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysOperatorRole> queryAllByLimit(int offset, int limit) {
        return this.sysOperatorRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysOperatorRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysOperatorRole insert(SysOperatorRole sysOperatorRole) {
        this.sysOperatorRoleDao.insert(sysOperatorRole);
        return sysOperatorRole;
    }

    /**
     * 修改数据
     *
     * @param sysOperatorRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysOperatorRole update(SysOperatorRole sysOperatorRole) {
        this.sysOperatorRoleDao.update(sysOperatorRole);
        return this.queryById(sysOperatorRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysOperatorRoleDao.deleteById(id) > 0;
    }
}