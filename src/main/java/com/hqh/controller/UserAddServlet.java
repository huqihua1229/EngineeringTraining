package com.hqh.controller;

import com.alibaba.fastjson.JSONObject;
import com.hqh.bean.UserBean;
import com.hqh.dto.JsonMessage;
import com.hqh.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        String username = req.getParameter("account");
        String password = req.getParameter("password");
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);

        System.out.println(userBean);

        ApplicationContext context =new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");



        JsonMessage jsonMessage = userService.add(userBean);
        String result = JSONObject.toJSONString(jsonMessage);
        System.out.println(result);
        resp.getWriter().println(result);
    }
}
