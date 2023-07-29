package com.example.springbootrestfulwebservices.service;

import com.example.springbootrestfulwebservices.entity.User;

import java.util.List;


public interface UserService {

    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUserById(Long id, User user);
    void deleteUserById(Long id);
}
