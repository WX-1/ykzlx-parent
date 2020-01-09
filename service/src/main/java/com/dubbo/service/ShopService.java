package com.dubbo.service;

import com.dubbo.pojo.Shop;
import com.github.pagehelper.PageInfo;

public interface ShopService {
    PageInfo<Shop> list(String sname, int pageNum, int pageSize);

    void add(Shop shop);

    void shangjia(Integer sid);

    void xiajia(Integer sid);

    Shop findById(Integer sid);

    Shop findOne(Integer sid);
}
