package com.fzu.hqh.service;

import com.fzu.hqh.bean.UserBean;
import com.fzu.hqh.dto.JsonMessage;
import com.fzu.hqh.dto.Page;

public interface UserService {
    JsonMessage login(String userName, String password);

    JsonMessage add(UserBean userBean);

    Page getList(Integer page, Integer recPerPage);
}
