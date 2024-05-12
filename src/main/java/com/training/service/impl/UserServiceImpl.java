package com.training.service.impl;

import com.training.entity.User;
import com.training.repository.UserRepository;
import com.training.service.UserService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> newUser = userRepository.findById(userId);
        if (newUser.isPresent()) {
            User foundUser = newUser.get();
            foundUser.setUsername(user.getUsername());
            userRepository.save(foundUser);
            return foundUser;
        }
        return null;
    }

    @Override
    public User createUserWithCustomQuery(Long userId, String email, String firstName, String lastName, String username) {
        userRepository.createUserWithCustomQuery(userId, email, firstName, lastName, username);
        return new User(userId, email, firstName, lastName, username);
    }
}
