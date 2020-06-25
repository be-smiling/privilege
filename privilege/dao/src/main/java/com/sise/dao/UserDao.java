package com.sise.dao;

import com.sise.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    @Select("select * from sys_user where username = #{username} and status = 1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "roleList", column = "id", javaType = List.class,
                    many = @Many(select = "com.sise.dao.RoleDao.findRoleListByUserId", fetchType = FetchType.LAZY))
    })
    SysUser findByUsername(String username);

    @Select("select * from sys_user")
    List<SysUser> findAll();

    @Insert("insert into sys_user values(null, #{username}, #{email}, #{password}, #{phoneNum}, #{status})")
    void save(SysUser user);

    @Select("select * from sys_user where username = #{username}")
    SysUser findAllUsersByUsername(String username);

    @Select("select * from sys_user where id = #{userId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "roleList", column = "id", javaType = List.class,
            many = @Many(select = "com.sise.dao.RoleDao.findRoleListByUserId", fetchType = FetchType.LAZY))
    })
    SysUser findById(Integer userId);

    @Delete("delete from sys_user_role where userId =#{userId}")
    void delRolesFromUser(Integer userId);

    @Insert("insert into sys_user_role values(#{param1}, #{param2})")
    void saveRoleToUser(Integer userId, Integer roleId);
}
