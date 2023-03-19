package com.fzu.hqh.mapper;

import com.fzu.hqh.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where user_name=#{username} and password=#{password}")
    @Results(value = {@Result(property = "username", column = "user_name"),
            @Result(property = "password", column = "password")})
    UserBean login(@Param("username") String username, @Param("password") String password);

    @Insert("insert into user (user_name, password)values (#{username}, #{password})")
    Integer add(UserBean userBean);

    @Select("select user_name as username, password from user")
    List<UserBean> getList();

    @Select("select count(user_name) from user")
    Integer getCount();
}
