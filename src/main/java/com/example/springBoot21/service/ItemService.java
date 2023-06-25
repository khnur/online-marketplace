package com.example.springBoot21.service;

import com.example.springBoot21.model.Item;
import com.example.springBoot21.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService{
    private final ItemRepo itemRepo;
    @Override
    public Item createItem(Item item) {
        item.setCreatedDateTime(new Date());
        item.setModifiedDateTime(new Date());
        return itemRepo.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }
}
