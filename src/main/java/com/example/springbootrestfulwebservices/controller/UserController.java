package com.example.springbootrestfulwebservices.controller;

import com.example.springbootrestfulwebservices.dto.UserDtoRecord;
import com.example.springbootrestfulwebservices.service.implementation.UserServiceImplementation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
@Tag(
        name = "User",
        description = "This is the user controller, it is responsible for handling the requests and sending the responses"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    // controller is the layer that is exposed to the client and it is responsible for handling the requests and sending the responses
    private UserServiceImplementation userServiceImplementation;

    @Operation(
            summary = "Create a new user",
            description = "This endpoint is responsible for creating a new user"
    )
    @ApiResponse(
            responseCode = "201",
            description = "User successfully created"
    )
    @PostMapping("/create")
    public ResponseEntity<UserDtoRecord> createUser(@RequestBody @Valid UserDtoRecord user) {
        UserDtoRecord createdUser = userServiceImplementation.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get a user by id",
            description = "This endpoint is responsible for getting a user by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "User successfully retrieved"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserDtoRecord> getUserById(@PathVariable Long id) {
        UserDtoRecord userDto = userServiceImplementation.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get all users",
            description = "This endpoint is responsible for getting all users"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Users successfully retrieved"
    )
    @GetMapping("/all")
    public ResponseEntity<List<UserDtoRecord>> getAllUsers() {
        List<UserDtoRecord> users = userServiceImplementation.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Update a user by id",
            description = "This endpoint is responsible for updating a user by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "User successfully updated"
    )
    @PutMapping("/{id}")
    public ResponseEntity<UserDtoRecord> updateUserById(@PathVariable long id, @RequestBody @Valid UserDtoRecord userDto) {
        userDto = new UserDtoRecord(id, userDto.firstName(), userDto.lastName(), userDto.email());
        UserDtoRecord updatedUser = userServiceImplementation.updateUserById(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete a user by id",
            description = "This endpoint is responsible for deleting a user by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "User successfully deleted"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userServiceImplementation.deleteUserById(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> resourceNotFoundExceptionHandler(ResourceNotFoundException exception, WebRequest WebRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                WebRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }

}
