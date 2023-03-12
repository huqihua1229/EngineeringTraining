package com.hqh.service;

import com.hqh.bean.UserBean;
import com.hqh.dto.JsonMessage;
import com.hqh.dto.Page;

public interface UserService {
    JsonMessage login(String userName, String password);

    JsonMessage add(UserBean userBean);

    Page getList(Integer page, Integer recPerPage);
}
