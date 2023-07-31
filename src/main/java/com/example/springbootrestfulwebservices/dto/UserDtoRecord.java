package com.example.springbootrestfulwebservices.dto;

import com.example.springbootrestfulwebservices.entity.User;

public record UserDtoRecord(long id, String firstName, String lastName, String email) {

    public UserDtoRecord(User user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }


}
