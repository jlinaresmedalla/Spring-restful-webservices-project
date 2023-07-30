package com.example.springbootrestfulwebservices.service;

import com.example.springbootrestfulwebservices.dto.UserDto;
import com.example.springbootrestfulwebservices.entity.User;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUserById(Long id, UserDto user);
    void deleteUserById(Long id);
}
