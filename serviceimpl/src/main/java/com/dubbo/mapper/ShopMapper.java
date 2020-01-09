package com.dubbo.mapper;

import com.dubbo.pojo.Result;
import com.dubbo.pojo.Shop;
import com.dubbo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ShopMapper extends Mapper<Shop> {

    @Select("select * from t_shop where sname like concat('%',#{sname},'%')")
    List<Shop> list(String sname);

    @Insert("insert into t_shop(sname,price,num,state) values(#{sname},#{price},#{num},1)")
    void add(Shop shop);

    @Update("update t_shop set state=1 where sid=#{sid}")
    void shangjia(Integer sid);

    @Update("update t_shop set state=2 where sid=#{sid}")
    void xiajia(Integer sid);

    @Select("select * from t_shop where sid=#{sid}")
    Shop findById(Integer sid);

    @Select("select * from t_shop where sid=#{sid}")
    Shop findOne(Integer sid);
}