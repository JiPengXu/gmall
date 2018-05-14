package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ManageController {
    @Reference
    private AttrService attrService;

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("attrListPage")
    public String attrListPage() {
        //  System.out.println("走了");
        return "attrListPage";
    }

    @RequestMapping("spuListPage")
    public String spuListPage() {
        //  System.out.println("走了");
        return "spuListPage";
    }
    @ResponseBody
    @RequestMapping("getCatalog1")
    public List<BaseCatalog1> getCatalog1() {
        return attrService.getCatalog1();
    }

    @ResponseBody
    @RequestMapping("getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {

        return attrService.getCatalog2(catalog1Id);
    }

    @ResponseBody
    @RequestMapping("getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {

        return attrService.getCatalog3(catalog2Id);
    }


    @RequestMapping("getAttrList")
    @ResponseBody
    public List<BaseAttrInfo> getAttrList(@RequestParam Map<String,String> map) {
        String catalog3Id =map.get("catalog3Id") ;
       System.out.println(catalog3Id);

        return attrService.getAttrList(catalog3Id);
    }
    @ResponseBody
    @RequestMapping("saveAttr")
    public String saveAttr(BaseAttrInfo baseAttrInfo) {
        attrService.saveAttr(baseAttrInfo);
        return "success";
    }
    @ResponseBody
    @RequestMapping("getAttrValueList")
    public List<BaseAttrValue> getAttrValueList(String attrId) {
        //根据属性id进行查询到属性值  因为BaseAttrInfo类里面封装了BaseAttrValue所以根据id查到属性就可以获取到属性值
        System.out.println(attrId);
        BaseAttrInfo attrInfo=attrService.getAttrInfo(attrId);

        return attrInfo.getAttrValueList();
    }

}
