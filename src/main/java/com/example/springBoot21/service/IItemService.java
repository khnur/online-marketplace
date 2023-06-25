package com.example.springBoot21.service;

import com.example.springBoot21.model.Item;

import java.util.List;

public interface IItemService {
    Item createItem(Item item);
    List<Item> getAllItems();
}
