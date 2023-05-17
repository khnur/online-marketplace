package com.example.springBoot21.service;

import com.example.springBoot21.dto.UserDto;
import com.example.springBoot21.model.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserByPhone(String phone);
}
