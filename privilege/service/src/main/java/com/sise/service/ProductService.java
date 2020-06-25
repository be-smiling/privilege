package com.sise.service;

import com.github.pagehelper.PageInfo;
import com.sise.domain.PageBean;
import com.sise.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Long id);

    void update(Product product);

    void delOne(Integer id);

    void delMany(Integer[] ids);

    PageBean<Product> findByPage(Integer currPage, Integer pageSize);

    PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize);

    public void testFindByPageHelper(Integer currPage, Integer pageSize);
}
