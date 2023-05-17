package com.example.springBoot21.controller;

import com.example.springBoot21.dto.ErrorDto;
import com.example.springBoot21.dto.UserDto;
import com.example.springBoot21.exceptions.UserAlreadyExistsException;
import com.example.springBoot21.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{phone}")
    public UserDto getUserByPhone(@PathVariable String phone) {
        return userService.getUserByPhone(phone);
    }

}
