package com.sise.service;

import com.sise.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<SysUser> findAll();

    void save(SysUser user);

    boolean isUniqueUsername(String username);

    SysUser findById(Integer userId);

    void addRoleToUser(Integer userId, Integer[] ids);
}
