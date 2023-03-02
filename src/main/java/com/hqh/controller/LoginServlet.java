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
        super.doGet(req, resp);
        String username = req.getParameter("account");
        String password = req.getParameter("password");
//        String resource = "/mybatis/mybatis-config.xml";
//
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
//
//        SqlSession session = sqlSessionFactory.openSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        UserBean user = mapper.login(username, password);
//
//        System.out.println(user);

        ApplicationContext context =new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        JsonMessage jsonMessage = userService.login(username, password);

        String result = JSONObject.toJSONString(jsonMessage);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");
        resp.getWriter().println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
