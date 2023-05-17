package com.example.springBoot21.controller;

import com.example.springBoot21.dto.UserDto;
import com.example.springBoot21.mappers.UserListMapper;
import com.example.springBoot21.mappers.UserMapper;
import com.example.springBoot21.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return UserMapper.INSTANCE.userToUserDto(
                userService.createUser(
                        UserMapper.INSTANCE.userDtoToUser(userDto)
                )
        );
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return UserListMapper.INSTANCE.userListToUserDtoList(userService.getAllUsers());
    }

    @GetMapping("/{phone}")
    public UserDto getUserByPhone(@PathVariable String phone) {
        return UserMapper.INSTANCE.userToUserDto(userService.getUserByPhone(phone));
    }

}
