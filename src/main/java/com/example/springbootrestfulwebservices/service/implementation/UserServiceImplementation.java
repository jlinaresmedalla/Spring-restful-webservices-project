package com.example.springbootrestfulwebservices.service.implementation;

import com.example.springbootrestfulwebservices.dto.UserDto;
import com.example.springbootrestfulwebservices.entity.User;
import com.example.springbootrestfulwebservices.mapper.UserMapper;
import com.example.springbootrestfulwebservices.repository.UserRespository;
import com.example.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    //@Autowired This is not needed because we have @AllArgsConstructor, also we are using constructor injection
    //instead of field injection which is a better practice and this class has only one attribute or argument in the constructor
    private UserRespository userRespository;


    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto to User entity object JPA
        User user = UserMapper.mapToUser(userDto);
        User createdUser = userRespository.save(user);
        //Convert User entity object JPA to UserDto
        UserDto createdUserDto = UserMapper.mapToUserDto(createdUser);
        return createdUserDto;
    }
    @Override
    public UserDto getUserById(Long id){
        Optional<User> optionalUser = userRespository.findById(id);
        User user = optionalUser.get();
        UserDto userDto = UserMapper.mapToUserDto(user);
        return userDto;
    }
    @Override
    public List<UserDto> getAllUsers(){
        List<User> allUsers = userRespository.findAll();
        List<UserDto> allUsersDto = allUsers.stream().map(UserMapper::mapToUserDto).toList();
//        List<UserDto> allUsersDto = new ArrayList<>();
//        for(User user : allUsers) {
//            UserDto userDto = UserMapper.mapToUserDto(user);
//            allUsersDto.add(userDto);
//        }
        return allUsersDto;
    }
    @Override
    public UserDto updateUserById(Long id, UserDto userDto){
        User userByID = userRespository.findById(id).get();
        userByID.setFirstName(userDto.getFirstName());
        userByID.setLastName(userDto.getLastName());
        userByID.setEmail(userDto.getEmail());
        UserDto updatedUserDto = UserMapper.mapToUserDto(userByID);
        return updatedUserDto;
    }
    @Override
    public void deleteUserById(Long id){
        userRespository.deleteById(id);
    }

}
