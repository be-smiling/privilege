package com.sise.domain;

import java.util.ArrayList;
import java.util.List;

public class Role {

    private Long id;
    private String roleName;
    private String roleDesc;
    //一个角色被多个用户所对应
    private List<SysUser> userList = new ArrayList<>();
    //一个角色对应多个权限
    private List<Permission> permissionList = new ArrayList<>();

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
