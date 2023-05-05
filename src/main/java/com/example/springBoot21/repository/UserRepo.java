package com.example.springBoot21.repository;

import com.example.springBoot21.dto.UserDto;
import com.example.springBoot21.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
//    @Query("SELECT * FROM")
    User getByPhone(String phone);
    boolean existsByPhone(String phone);
}
