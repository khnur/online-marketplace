package com.example.springBoot21.repository;

import com.example.springBoot21.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
}
