package com.yuntian.security.service.impl;

import com.yuntian.security.model.entity.SysMenu;
import com.yuntian.security.dao.SysMenuDao;
import com.yuntian.security.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 后台系统-菜单表(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 10:52:09
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuDao sysMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysMenu queryById(Long id) {
        return this.sysMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysMenu> queryAllByLimit(int offset, int limit) {
        return this.sysMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu insert(SysMenu sysMenu) {
        this.sysMenuDao.insert(sysMenu);
        return sysMenu;
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu update(SysMenu sysMenu) {
        this.sysMenuDao.update(sysMenu);
        return this.queryById(sysMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysMenuDao.deleteById(id) > 0;
    }

    @Override
    public List<String> getMenuListByUserId(Long id) {
        if (id==1){
             return Stream.of("ROLE_ADMIN","menu","menu:list","user","user:list","user:add").collect(Collectors.toList());
        }else if (id==2){
             return Stream.of("user","user:list","user:add").collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}