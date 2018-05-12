package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.bean.UserAddress;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface UserAddressMapper extends Mapper<UserAddress> {
    @Select("select * from user_address where user_id=#{userId}")
    List<UserAddress> getSelect(String userId);
}
