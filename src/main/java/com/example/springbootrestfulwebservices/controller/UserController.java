package com.example.springbootrestfulwebservices.controller;

import com.example.springbootrestfulwebservices.dto.UserDtoRecord;
import com.example.springbootrestfulwebservices.service.implementation.UserServiceImplementation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    // controller is the layer that is exposed to the client and it is responsible for handling the requests and sending the responses
    private UserServiceImplementation userServiceImplementation;

    @PostMapping("/create")
    public ResponseEntity<UserDtoRecord> createUser(@RequestBody @Valid UserDtoRecord user) {
        UserDtoRecord createdUser = userServiceImplementation.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoRecord> getUserById(@PathVariable Long id) {
        UserDtoRecord userDto = userServiceImplementation.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDtoRecord>> getAllUsers() {
        List<UserDtoRecord> users = userServiceImplementation.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDtoRecord> updateUserById(@PathVariable long id, @RequestBody @Valid UserDtoRecord userDto) {
        userDto = new UserDtoRecord(id, userDto.firstName(), userDto.lastName(), userDto.email());
        UserDtoRecord updatedUser = userServiceImplementation.updateUserById(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

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
