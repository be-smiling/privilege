package com.sise.dao;

import com.sise.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {



    @Select("select * from sys_permission")
    List<Permission> findAll();

    @Select("select * from sys_permission where pid = 0")
    List<Permission> findAllParentPermission();

    @Insert("insert into sys_permission values (null, #{permissionName}, #{url}, #{pid})")
    void save(Permission permission);

    @Select("SELECT p.* FROM sys_role_permission rp LEFT JOIN sys_permission p ON rp.permissionId = p.id WHERE roleId = #{roleId}")
    List<Permission> findPermissionListByRoleId(Integer roleId);
}
