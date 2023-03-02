package com.hqh.controller;

import com.hqh.bean.UserBean;
import com.hqh.dto.JsonMessage;
import com.hqh.mapper.UserMapper;
import com.hqh.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.alibaba.fastjson.JSONObject;
import java.io.InputStream;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("account");
        String password = req.getParameter("password");

        ApplicationContext context =new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        JsonMessage jsonMessage = userService.login(username, password);

        String result = JSONObject.toJSONString(jsonMessage);
        System.out.println(result);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");
        resp.getWriter().println(result);
    }
}
