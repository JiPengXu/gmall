package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> userList() {
        List<UserInfo> userInfos = userMapper.selectAll();
        return userInfos;


    }

    @Override
    public void add(UserInfo userInfo) {
        userMapper.insertSelective(userInfo);
        System.out.println(userInfo.getId());

    }


}
