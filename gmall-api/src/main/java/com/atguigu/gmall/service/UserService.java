package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> userList();
    void add(UserInfo userInfo);
    List<UserAddress> getUserAddress(String userId);
}

