package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class SpuController {
    @Reference
    SpuService spuService;
    @RequestMapping("getSpuList")
    @ResponseBody
    public List<SpuInfo> getSpuList(@RequestParam Map<String,String> map) {
        String catalog3Id =map.get("catalog3Id") ;
        //System.out.println(catalog3Id);

        return spuService.getSpuList(catalog3Id);
    }

    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<BaseSaleAttr> baseSaleAttrList() {



        return spuService.baseSaleAttrList();
    }

    @RequestMapping("saveSpu")
    @ResponseBody
    public String saveSpu(SpuInfo spuInfo) {

        spuService.saveSpu(spuInfo);

        return "保存成功";
    }
}
