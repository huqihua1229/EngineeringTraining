package com.hqh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("login")
    public String login(String account, String password){
        return "account: " + account + " password: " + password;
    }
}
