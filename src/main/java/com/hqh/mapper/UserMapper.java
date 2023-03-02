package com.hqh.mapper;

import com.hqh.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where user_name=#{username} and password=#{password}")
    @Results(value = {@Result(property = "username", column = "user_name"),
            @Result(property = "password", column = "password")})
    UserBean login(@Param("username") String username, @Param("password") String password);

    @Select("insert into user values (#{username}, #{password})")
    Integer add(UserBean userBean);
}
