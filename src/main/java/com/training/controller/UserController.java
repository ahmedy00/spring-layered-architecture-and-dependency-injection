package com.training.controller;

import com.training.entity.User;
import com.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void removeUser(@PathVariable Long userId) {
        userService.removeUser(userId);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, User user) {
        return userService.updateUser(userId, user);
    }

    @PostMapping("/users/custom")
    public User createUserWithCustomQuery(@RequestBody User user) {
        return userService.createUserWithCustomQuery(user.getUserId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getUsername());
    }

}
