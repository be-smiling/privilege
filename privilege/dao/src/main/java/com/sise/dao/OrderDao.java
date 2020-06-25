package com.sise.dao;

import com.sise.domain.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderDao {

    @Select("select * from orders")
    @Results({
            @Result(
                    property = "product",
                    column = "productId",
                    one = @One(select = "com.sise.dao.ProductDao.findById", fetchType = FetchType.EAGER)
            )
    })
    List<Order> findAll();

    @Insert("insert into orders values(null ,#{orderNum}, #{orderTime}  ,#{peopleCount},#{orderDesc}, #{payType} , #{orderStatus} , #{product.id})")
    void save(Order order);
}
