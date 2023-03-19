package com.fzu.hqh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("index")
    @ResponseBody
    public String name(){
        System.out.println("index");
        return "hello.html";
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello1";
    }
}
