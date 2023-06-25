package com.example.springBoot21.service;

import com.example.springBoot21.exceptions.ItemNotExistsException;
import com.example.springBoot21.exceptions.UserNotExistsException;
import com.example.springBoot21.model.Item;
import com.example.springBoot21.model.Order;
import com.example.springBoot21.model.OrderItem;
import com.example.springBoot21.model.OrderItemKey;
import com.example.springBoot21.repository.ItemRepo;
import com.example.springBoot21.repository.OrderItemRepo;
import com.example.springBoot21.repository.OrderRepo;
import com.example.springBoot21.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepo orderRepo;
    private final ItemRepo itemRepo;
    private final UserRepo userRepo;
    private final OrderItemRepo orderItemRepo;

    @Override
    public Order createOrder(Order order) {
        order.setUser(
                userRepo.findById(order.getUser().getId())
                        .orElseThrow(() -> new UserNotExistsException("There is no user with such id"))
        );

        order.getOrderItems()
                .forEach(orderItem -> {
                    Item item = itemRepo.findById(orderItem.getItem().getId())
                            .orElseThrow(() -> new ItemNotExistsException("There is no item with such id"));
                    orderItem.setItem(item);
                    orderItem.setSubtotal(orderItem.getQuantity() * item.getPrice());
                });

        order.setTotalPrice(order.getOrderItems()
                .stream().map(OrderItem::getSubtotal)
                .reduce(Double::sum).orElse(0D)
        );

        order.setCreatedDateTime(new Date());

        orderRepo.save(order);

        order.getOrderItems()
                .forEach(orderItem -> {
                    orderItem.setId(new OrderItemKey(order.getId(), orderItem.getItem().getId()));
                    orderItem.setOrder(order);
                });

        orderItemRepo.saveAll(order.getOrderItems());

        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
