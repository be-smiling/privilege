package com.sise.controller;


import com.sise.domain.Role;
import com.sise.domain.SysUser;
import com.sise.service.RoleService;
import com.sise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
@Secured({"ROLE_ADMIN"})
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        List<SysUser> userList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;

    }

    @RequestMapping("/save")
    public String save(SysUser user){
        userService.save(user);
        return "redirect:/user/findAll";

    }

    @RequestMapping("/isUniqueUsername")
    @ResponseBody
    public String isUniqueUsername(String username){
        boolean b = userService.isUniqueUsername(username);
        return String.valueOf(b);

    }

    @RequestMapping("/details")
    public ModelAndView details(Integer userId){
        SysUser user = userService.findById(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-show");
        return modelAndView;

    }

    @RequestMapping("/addRoleToUserUI")
    public ModelAndView addRoleToUserUI(Integer userId){

        List<Role> roleList = roleService.findAll();
        SysUser user = userService.findById(userId);
        List<Role> userWithRoleList = user.getRoleList();
        StringBuffer sb = new StringBuffer();
        for (Role role : userWithRoleList) {
            sb.append(",");
            sb.append(role.getId());
            sb.append(",");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList", roleList);
        modelAndView.addObject("str", sb.toString());
        modelAndView.addObject("userId", userId);
        modelAndView.setViewName("user-role-add");
        return modelAndView;

    }




    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(Integer userId, Integer[] ids){
        userService.addRoleToUser(userId, ids);
        return "redirect:/user/findAll";

    }

}
