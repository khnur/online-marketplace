package com.example.springBoot21.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private ItemDto item;
    private int quantity;
    private double subtotal;
}
