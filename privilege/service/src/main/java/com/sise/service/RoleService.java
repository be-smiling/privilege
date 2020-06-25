package com.sise.service;

import com.sise.domain.Role;

import java.util.List;

public interface RoleService  {
    List<Role> findAll();

    void save(Role role);

    Role findById(Integer roleId);

    void addPermissionsToRole(Integer roleId, Integer[] ids);
}
