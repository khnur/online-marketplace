package com.example.springBoot21.repository;

import com.example.springBoot21.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
//    @Query("SELECT * FROM")
    List<User> findAll();
    Optional<User> findByPhone(String phone);
    boolean existsByPhone(String phone);
}
