package com.sise.dao;

import com.sise.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleDao {

    @Select("select * from sys_role")
    List<Role> findAll();

    @Insert("insert into sys_role values(null, #{roleName}, #{roleDesc})")
    void save(Role role);

    @Select("SELECT r.* FROM sys_user_role ur LEFT JOIN sys_role r ON ur.roleId = r.id WHERE userId = #{userId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "permissionList", column = "id", javaType = List.class,
                    many = @Many(select = "com.sise.dao.PermissionDao.findPermissionListByRoleId",fetchType = FetchType.LAZY))
    })
    List<Role> findRoleListByUserId(Integer roleId);

    @Select("select * from sys_role where id = #{roleId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "permissionList", column = "id", javaType = List.class,
                    many = @Many(select = "com.sise.dao.PermissionDao.findPermissionListByRoleId",fetchType = FetchType.LAZY))
    })
    Role findById(Integer roleId);

    @Delete("delete from sys_role_permission where roleId = #{roleId}")
    void delPermissionsFromRole(Integer roleId);

    @Insert("insert into sys_role_permission values(#{param2}, #{param1})")
    void addPermissionToRole(Integer roleId, Integer permissionId);
}
