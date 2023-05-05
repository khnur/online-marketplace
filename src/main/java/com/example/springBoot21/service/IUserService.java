package com.example.springBoot21.service;

import com.example.springBoot21.dto.UserDto;

import java.util.List;

public interface IUserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserByPhone(String phone);
}
