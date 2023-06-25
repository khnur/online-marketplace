package com.example.springBoot21.service;

import com.example.springBoot21.model.Order;

import java.util.List;

public interface IOrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
}
