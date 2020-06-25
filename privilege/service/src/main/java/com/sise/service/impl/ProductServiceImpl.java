package com.sise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.dao.ProductDao;
import com.sise.domain.PageBean;
import com.sise.domain.Product;
import com.sise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delOne(Integer id) {
        productDao.delById(id);
    }

    @Override
    public void delMany(Integer[] ids) {
        if (null != ids) {
            for (Integer id : ids) {
                productDao.delById(id);
            }
        }
    }

    @Override
    public PageBean<Product> findByPage(Integer currPage, Integer pageSize) {
        PageBean<Product> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currPage);
        pageBean.setPageSize(pageSize);
        Long totalCount = productDao.findTotalCount();
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage((int)Math.ceil(totalCount *1.0/pageSize));
        List<Product> productList = productDao.findByPage((currPage-1)*pageSize, pageSize);
        pageBean.setList(productList);
        return pageBean;
    }

    @Override
    public PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize) {
        PageHelper.startPage(currPage, pageSize);
        //查询全部
        List<Product> productList = productDao.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(productList, 3);
        return pageInfo;
    }

    @Override
    public void testFindByPageHelper(Integer currPage, Integer pageSize) {
        PageHelper.startPage(currPage, pageSize);
//        查询全部
        List<Product> productList = productDao.findAll();

        PageInfo<Product> pageInfo = new PageInfo<>(productList);

        System.out.println(pageInfo);
        System.out.println("上一页页码:"+ pageInfo.getPrePage());
    }
}
