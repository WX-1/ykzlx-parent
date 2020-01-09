package com.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.mapper.OrderMapper;
import com.dubbo.pojo.Order;
import com.dubbo.pojo.Shop;
import com.dubbo.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<Order> olist(String oname, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> olist = orderMapper.olist(oname);
        PageInfo<Order> pageInfo = new PageInfo<Order>(olist);
        return pageInfo;
    }
}
