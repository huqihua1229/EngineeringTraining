package com.hqh.service;

import com.hqh.bean.UserBean;
import com.hqh.dto.JsonMessage;

public interface UserService {
    JsonMessage login(String userName, String password);

    JsonMessage add(UserBean userBean);
}
