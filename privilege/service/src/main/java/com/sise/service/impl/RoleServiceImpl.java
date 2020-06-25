package com.sise.service.impl;

import com.sise.dao.RoleDao;
import com.sise.domain.Role;
import com.sise.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public void addPermissionsToRole(Integer roleId, Integer[] ids) {
        //1.删除该角色下所有权限
        roleDao.delPermissionsFromRole(roleId);
        //2.遍历每一个权限添加之
        if (ids != null){
            for (Integer permissionId : ids) {
                roleDao.addPermissionToRole(roleId, permissionId);
            }
        }

    }
}
