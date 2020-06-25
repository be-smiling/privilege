package com.sise.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/*.xml")
public class TestPageHelper {

    @Autowired
    ProductService productService;

    @Test
    public void test(){
        productService.testFindByPageHelper(1, 5);
    }
}
