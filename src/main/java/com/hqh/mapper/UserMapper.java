package com.hqh.mapper;

import com.hqh.bean.UserBean;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Select("select * from user where user_name=#{username} and password=#{password}")
    @Results(value = {@Result(property = "username", column = "user_name"),
            @Result(property = "password", column = "password")})
    UserBean login(@Param("username") String username, @Param("password") String password);

    @Insert("insert into user (user_name, password)values (#{username}, #{password})")
    Integer add(UserBean userBean);
}
