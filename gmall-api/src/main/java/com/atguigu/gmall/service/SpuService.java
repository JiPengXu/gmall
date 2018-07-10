package com.atguigu.gmall.service;
//加了一行注解
//加注解
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuInfo;

import java.util.List;

public interface SpuService {
    List<SpuInfo> getSpuList(String catalog3Id);

    List<BaseSaleAttr> baseSaleAttrList();

    void saveSpu(SpuInfo spuInfo);
}
