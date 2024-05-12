package com.training.service.impl;

import com.training.entity.User;
import com.training.repository.UserRepository;
import com.training.service.UserService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId) {
        // Validation
        if (userId == null) {
            throw new InvalidParameterException("Invalid user ID");
        }
        // TODO: Add custom exception.
        return userRepository.findById(userId).orElseThrow(null);
    }
}
