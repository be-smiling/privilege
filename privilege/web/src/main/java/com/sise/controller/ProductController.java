package com.sise.controller;

import com.github.pagehelper.PageInfo;
import com.sise.domain.PageBean;
import com.sise.domain.Product;
import com.sise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize){
        PageInfo<Product> pageInfo = productService.findByPageHelper(currPage, pageSize);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/findAll2")
    public ModelAndView findAll2(
            @RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize){
        PageBean<Product> pageBean = productService.findByPage(currPage, pageSize);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/findAll1")
    public ModelAndView findAll1(){
        List<Product> productList = productService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        System.out.println(product.getId());
        return "redirect:/product/findAll";
    }

    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Long id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("product-update");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Product product){
        productService.update(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/delOne")
    public String delOne(Integer id){
        productService.delOne(id);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/delMany")
    public String delMany(Integer[] ids){
        productService.delMany(ids);
        return "redirect:/product/findAll";
    }
}
