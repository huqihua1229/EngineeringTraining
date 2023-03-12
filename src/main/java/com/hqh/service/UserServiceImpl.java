package com.hqh.service;

import com.hqh.bean.UserBean;
import com.hqh.dto.JsonMessage;
import com.hqh.dto.Page;
import com.hqh.dto.Pager;
import com.hqh.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

        if(page <= 0){
            page = 1;
        }
        int offset = (page - 1) * recPerPage;
        RowBounds rowBounds = new RowBounds(offset, recPerPage);
        List<UserBean> userList = userMapper.getList(rowBounds);
        resultPage.setData(userList);

        Pager pager = new Pager();
        pager.setPage(page);
        pager.setRecPerPage(recPerPage);
        pager.setRecTotal(userMapper.getCount());

        resultPage.setPager(pager);

        return resultPage;
    }
}
