package com.sise.controller;

import com.sise.domain.Order;
import com.sise.domain.Product;
import com.sise.service.OrderService;
import com.sise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Order> orderList = orderService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderList", orderList);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }

    @RequestMapping("/addUI")
    public ModelAndView addUI(){
        List<Product> productList = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", productList);
        modelAndView.setViewName("order-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String add(Order order){
        orderService.save(order);
        return "redirect:/order/findAll";
    }
}
