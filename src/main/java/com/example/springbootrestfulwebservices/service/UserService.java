package com.example.springbootrestfulwebservices.service;

import com.example.springbootrestfulwebservices.dto.UserDtoRecord;

import java.util.List;


public interface UserService {

    UserDtoRecord createUser(UserDtoRecord user);
    UserDtoRecord getUserById(Long id);
    List<UserDtoRecord> getAllUsers();
    UserDtoRecord updateUserById(Long id, UserDtoRecord user);
    void deleteUserById(Long id);
}
