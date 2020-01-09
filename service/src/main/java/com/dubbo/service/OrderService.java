package com.dubbo.service;

import com.dubbo.pojo.Order;
import com.github.pagehelper.PageInfo;

public interface OrderService {
    PageInfo<Order> olist(String oname, int pageNum, int pageSize);
}
