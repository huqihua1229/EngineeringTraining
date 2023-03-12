package com.hqh.controller;

import com.alibaba.fastjson.JSONObject;
import com.hqh.dto.JsonMessage;
import com.hqh.dto.Page;
import com.hqh.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context =new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        Integer page = Integer.valueOf(req.getParameter("page"));
        Integer recPerPage = Integer.valueOf(req.getParameter("recPerPage"));
        Page page1 = userService.getList(page, recPerPage);

        String result = JSONObject.toJSONString(page1);
        System.out.println(result);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");
        resp.getWriter().println(result);
    }
}
