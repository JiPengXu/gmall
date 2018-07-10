package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//订单层
@Controller
public class OrederController {
    @Reference
    private UserService userService;

    @RequestMapping("initOrder")
    @ResponseBody
    public List<UserInfo> initOrder(){
        List<UserInfo> userInfos = userService.userList();
        return  userInfos;
    }
    @ResponseBody
    @RequestMapping("getUserAddress")

    public List<UserAddress> getUserAddress(String userId){
        System.out.println(userId);
        List<UserAddress> userAddress = userService.getUserAddress(userId);
        return  userAddress;

    }

}
