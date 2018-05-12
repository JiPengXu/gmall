package com.atguigu.gmall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Reference
    private UserService userService;

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("userList")
    public ResponseEntity<List<UserInfo>> userList() {
        List<UserInfo> userInfo = userService.userList();
        return ResponseEntity.ok(userInfo);
    }

    @RequestMapping("add")
    public void add(UserInfo userInfo) {
        userService.add(userInfo);
        System.out.println(userInfo.getId());


    }

    @RequestMapping("getUserAddress")
    public List<UserAddress> getUserAddress(String userId) {
        List<UserAddress> userAddress = userService.getUserAddress(userId);
        return userAddress;
    }


}
