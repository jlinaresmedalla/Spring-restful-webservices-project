package com.example.springbootrestfulwebservices.dto;

import com.example.springbootrestfulwebservices.entity.User;
import jakarta.validation.constraints.NotEmpty;

public record UserDtoRecord(
        long id,
        @NotEmpty(message = "First name cannot be empty")
        String firstName,
        @NotEmpty(message = "Last name cannot be empty")
        String lastName,
        @NotEmpty(message = "Email cannot be empty")
        String email) {

    public UserDtoRecord(User user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }


}
