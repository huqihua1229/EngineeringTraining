package com.hqh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Demo")
public class IndexController {

    @RequestMapping("index")
    @ResponseBody
    public String name(){
        System.out.println("index");
        return "hello.html";
    }
}
