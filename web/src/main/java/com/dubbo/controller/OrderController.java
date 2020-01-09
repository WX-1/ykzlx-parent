package com.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.pojo.Order;
import com.dubbo.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Reference
    private OrderService orderService;

    @RequestMapping("/olist")
    public PageInfo<Order> olist(String oname, @RequestParam(defaultValue = "0")int pageNum, @RequestParam(defaultValue = "2")int pageSize){
        return orderService.olist(oname,pageNum,pageSize);
    }
}
