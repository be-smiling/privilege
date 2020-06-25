package com.sise.service;

import com.sise.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    void save(Order order);
}
