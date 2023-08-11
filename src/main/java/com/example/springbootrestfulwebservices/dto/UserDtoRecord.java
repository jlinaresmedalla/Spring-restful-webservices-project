package com.example.springbootrestfulwebservices.dto;

import com.example.springbootrestfulwebservices.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(
        name = "User",
        description = "This is the user data transfer object"
)
public record UserDtoRecord(
        long id,
        @Schema(
                description = "First name of the user",
                example = "John"
        )
        @NotEmpty(message = "First name cannot be empty")
        String firstName,
        @Schema(
                description = "Last name of the user",
                example = "Doe"
        )
        @NotEmpty(message = "Last name cannot be empty")
        String lastName,
        @Schema(
                description = "Email of the user",
                example = "jhondoe@gmail.com"
        )
        @NotEmpty(message = "Email cannot be empty")
        String email) {

    public UserDtoRecord(User user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }


}
