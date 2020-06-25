package com.sise.controller;

import com.sise.domain.Permission;
import com.sise.domain.Role;
import com.sise.service.PermissionService;
import com.sise.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
@Secured({"ROLE_ADMIN"})
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {

        List<Role> roleList = roleService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) {

        roleService.save(role);
        return "redirect:/role/findAll";
    }


    @RequestMapping("/addPermissionsToRoleUI")
    public ModelAndView addPermissionsToRoleUI(Integer roleId) {
        //1.查询所有权限
        List<Permission> permissionList = permissionService.findAll();
        //2.查询该角色已经拥有的权限
        Role role = roleService.findById(roleId);
        StringBuffer sb = new StringBuffer();
        for (Permission permission : role.getPermissionList()) {
            sb.append(",");
            sb.append(permission.getId());
            sb.append(",");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.addObject("str",sb.toString());
        modelAndView.addObject("roleId",roleId);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }


    @RequestMapping("/addPermissionsToRole")
    public String addPermissionsToRole(Integer roleId, Integer[] ids) {

        roleService.addPermissionsToRole(roleId, ids);
        return "redirect:/role/findAll";
    }
}
