package com.fzu.hqh.service;

import com.github.pagehelper.PageHelper;
import com.fzu.hqh.bean.UserBean;
import com.fzu.hqh.dto.JsonMessage;
import com.fzu.hqh.dto.Page;
import com.fzu.hqh.dto.Pager;
import com.fzu.hqh.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    JsonMessage jsonMessage = new JsonMessage();

    @Resource
    UserMapper userMapper;



    public JsonMessage login(String userName, String password) {
        UserBean userBean = userMapper.login(userName, password);
        if(userBean!=null) {
            jsonMessage.setCode(1);
            jsonMessage.setMessage("登录成功！！");
            return jsonMessage;
        }
        return null;
    }

    @Override
    public JsonMessage add(UserBean userBean) {
        Integer result = userMapper.add(userBean);
        if(1 == result){
            jsonMessage.setCode(1);
            jsonMessage.setMessage("插入成功");
            return jsonMessage;
        }
        return null;
    }

    @Override
    public Page getList(Integer page, Integer recPerPage) {
        Page resultPage = new Page();

        resultPage.setResult("success");

        com.github.pagehelper.Page<UserBean> pageMap = PageHelper.startPage(page, recPerPage);
        userMapper.getList();
        Object data = pageMap.getResult();
        resultPage.setData(data);

        Pager pager = new Pager();
        pager.setPage(page);
        pager.setRecPerPage(recPerPage);
        pager.setRecTotal((int) pageMap.getTotal());

        resultPage.setPager(pager);

        return resultPage;
    }
}
