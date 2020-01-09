package com.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.pojo.Result;
import com.dubbo.pojo.Shop;
import com.dubbo.service.ShopService;
import com.github.pagehelper.PageInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ShopController {
    @Reference
    private ShopService shopService;

    @Value("${mystatic}")
    public String us;

    @Autowired
    private FreeMarkerConfig freeMarkerConfig;


    @ResponseBody
    @RequestMapping("/list")
    public PageInfo<Shop> list(String sname, @RequestParam(defaultValue = "0")int pageNum, @RequestParam(defaultValue = "2")int pageSize){
        return shopService.list(sname,pageNum,pageSize);
    }
    @ResponseBody
    @RequestMapping("/add")
    public Result add(@RequestBody Shop shop){
       try {
            shopService.add(shop);
            return new Result("添加成功", true);
       }catch (Exception e){
           e.printStackTrace();
       }
        return new Result("添加失败",false);
    }
    @ResponseBody
    @RequestMapping("/shangjia")
    public Shop shangjia(Integer sid) throws Exception {
            shopService.shangjia(sid);
            Configuration configuration = freeMarkerConfig.getConfiguration();
            Map map=new HashMap<>();
            Template template = configuration.getTemplate("freemark.ftl");
            Shop shop = shopService.findById(sid);
            map.put("shop",shop);
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(us+sid+".html", Boolean.parseBoolean("utf-8"))));
            template.process(map,writer);
            writer.close();
            return shop;
    }
    @ResponseBody
    @RequestMapping("/xiajia")
    public Result xiajia(Integer sid){
        try {
            shopService.xiajia(sid);
            return new Result("上架成功",true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result("上架失败",false);
    }

    @ResponseBody
    @RequestMapping("/findOne")
    public Shop findOne(Integer sid){
          return shopService.findOne(sid);
    }

 }
