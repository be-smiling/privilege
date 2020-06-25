package com.sise.service.impl;

import com.sise.dao.UserDao;
import com.sise.domain.Role;
import com.sise.domain.SysUser;
import com.sise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userDao.findByUsername(username);
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
//        authorities.add(grantedAuthority);
        if (sysUser != null){
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role : sysUser.getRoleList()) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
                authorities.add(grantedAuthority);

            }
            User user = new User(sysUser.getUsername(),sysUser.getPassword(), authorities);
            return user;
        }
        return null;
    }

    @Override
    public List<SysUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(SysUser user) {
        //对密码加密
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public boolean isUniqueUsername(String username) {
        SysUser user = userDao.findAllUsersByUsername(username);
        return user == null;
    }

    @Override
    public SysUser findById(Integer userId) {
        return userDao.findById(userId);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] ids) {
        userDao.delRolesFromUser(userId);
        if (ids != null){
            for (Integer roleId : ids) {
                userDao.saveRoleToUser(userId, roleId);
            }
        }
    }
}
