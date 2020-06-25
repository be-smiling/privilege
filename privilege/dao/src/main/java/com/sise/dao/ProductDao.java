package com.sise.dao;

import com.sise.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductDao {
    @Select("select * from product")
    List<Product> findAll();

    /*@Insert("insert into product values(null, #{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    void save(Product product);*/


    @Insert("insert into product values(#{id}, #{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    @SelectKey(keyProperty = "id", keyColumn = "id", before = false, resultType = Long.class,
    statement = "select last_insert_id()")
    void save(Product product);

    @Select("select * from product where id = #{id}")
    Product findById(Long id);

    @Update("update product set productNum = #{productNum}, productName = #{productName}, cityName = #{cityName}, departureTime = #{departureTime}, productPrice = #{productPrice}, productDesc = #{productDesc}, productStatus = #{productStatus} where id = #{id}")
    void update(Product product);

    @Delete("delete from product where id = #{abc}")
    void delById(Integer id);

    @Select("select count(1) from product")
    Long findTotalCount();

    @Select("select * from product limit #{param1}, #{param2}")
    List<Product> findByPage(Integer startIndex, Integer pageSize);
}
