package com.atguigu.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;

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
    public List<UserAddress> getUserAddress(String userId){
        UserAddress userAddress =new UserAddress();
        userAddress.setUserId(userId);
        List<UserAddress> select = userAddressMapper.getSelect(userId);
        return  select;
    }




}
