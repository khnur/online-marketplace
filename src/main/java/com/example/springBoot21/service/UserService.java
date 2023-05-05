package com.example.springBoot21.service;

import com.example.springBoot21.dto.UserDto;
import com.example.springBoot21.exceptions.UserAlreadyExistsException;
import com.example.springBoot21.repository.UserRepo;
import com.example.springBoot21.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        if (userRepo.existsByPhone(userDto.getPhone())) {
            throw new UserAlreadyExistsException("User with such number already registered");
        }
        return UserUtil.userToUserDto(userRepo.save(UserUtil.userDtoToUser(userDto)));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(UserUtil::userToUserDto).toList();
    }

    @Override
    public UserDto getUserByPhone(String phone) {
        return UserUtil.userToUserDto(userRepo.getByPhone(phone));
    }

}
