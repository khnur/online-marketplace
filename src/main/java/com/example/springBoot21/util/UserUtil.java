package com.example.springBoot21.util;

import com.example.springBoot21.dto.UserDto;
import com.example.springBoot21.model.User;

public class UserUtil {
    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPhone(user.getPhone());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAddress(user.getAddress());
        return userDto;
    }
    public static User userDtoToUser(UserDto userDto) {
        User user = new User(userDto.getId());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAddress(userDto.getAddress());
        return user;
    }
}
