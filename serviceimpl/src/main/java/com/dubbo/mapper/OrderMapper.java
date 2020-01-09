package com.dubbo.mapper;

import com.dubbo.pojo.Order;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    @Select("select * from t_order where oname like concat('%',#{oname},'%')")
    List<Order> olist(String oname);
}