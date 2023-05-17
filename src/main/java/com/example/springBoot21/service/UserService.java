package com.example.springBoot21.service;

import com.example.springBoot21.exceptions.UserAlreadyExistsException;
import com.example.springBoot21.exceptions.UserNotExistsException;
import com.example.springBoot21.model.User;
import com.example.springBoot21.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepo userRepo;

    @Override
    public User createUser(User user) {
        if (userRepo.existsByPhone(user.getPhone())) {
            throw new UserAlreadyExistsException("User with such number already registered");
        }
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByPhone(String phone) {
        return userRepo.findByPhone(phone)
                .orElseThrow(() -> new UserNotExistsException("There is no user with such phone"));
    }
}
