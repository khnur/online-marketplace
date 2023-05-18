package com.example.springBoot21.repository;

import com.example.springBoot21.model.OrderItem;
import com.example.springBoot21.model.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, OrderItemKey> {
}
