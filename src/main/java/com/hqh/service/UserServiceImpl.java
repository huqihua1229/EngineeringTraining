package com.hqh.service;

import com.hqh.bean.UserBean;
import com.hqh.dto.JsonMessage;
import com.hqh.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    JsonMessage jsonMessage = new JsonMessage();

    @Resource
    UserMapper userMapper;



    public JsonMessage login(String userName, String password) {
        UserBean userBean = userMapper.login(userName, password);
        if(userBean!=null) {
            jsonMessage.setCode(1);
            jsonMessage.setMessage("登录成功！！");
            return jsonMessage;
        }
        return null;
    }

    @Override
    public JsonMessage add(UserBean userBean) {
        Integer result = userMapper.add(userBean);
        if(1 == result){
            jsonMessage.setCode(1);
            jsonMessage.setMessage("插入成功");
            return jsonMessage;
        }
        return null;
    }
}
