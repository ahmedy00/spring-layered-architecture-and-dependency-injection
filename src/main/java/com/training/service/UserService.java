package com.training.service;

import com.training.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);

    List<User> getAllUsers();

    User createUser(User user);

    void removeUser(Long userId);

    User updateUser(Long userId, User user);

    User createUserWithCustomQuery(Long userId, String email, String firstName, String lastName, String username);
}
