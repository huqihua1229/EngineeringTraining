package com.hqh.controller;

import com.alibaba.fastjson.JSONObject;
import com.hqh.dto.JsonMessage;
import com.hqh.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("login")
    public String login(String account, String password){

        ApplicationContext context =new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        JsonMessage jsonMessage = userService.login(account, password);

        String result = JSONObject.toJSONString(jsonMessage);
        System.out.println(result);
        return "account: " + account + " password: " + password;
    }
}
