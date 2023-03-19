package com.fzu.hqh.controller;

import com.fzu.hqh.bean.UserBean;
import com.fzu.hqh.dto.JsonMessage;
import com.fzu.hqh.dto.Page;
import com.fzu.hqh.dto.Pager;
import com.fzu.hqh.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    UserService userService;

    @RequestMapping("login")
    public JsonMessage login(String account, String password){
        return userService.login(account, password);
    }

    @RequestMapping("userAdd")
    public JsonMessage userAdd(UserBean userBean){
        return userService.add(userBean);
    }

    @RequestMapping("userList")
    public Page userList(Pager pager){
        return userService.getList(pager.getPage(), pager.getRecPerPage());
    }
}
