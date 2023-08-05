package com.example.springbootrestfulwebservices.service.implementation;

import com.example.springbootrestfulwebservices.dto.UserDtoRecord;
import com.example.springbootrestfulwebservices.entity.User;
import com.example.springbootrestfulwebservices.exception.EmailAlreadyExistsException;
import com.example.springbootrestfulwebservices.exception.ResourceNotFoundException;
import com.example.springbootrestfulwebservices.repository.UserRespository;
import com.example.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    //@Autowired This is not needed because we have @AllArgsConstructor, also we are using constructor injection
    //instead of field injection which is a better practice and this class has only one attribute or argument in the constructor
    private UserRespository userRespository;


    @Override
    public UserDtoRecord createUser(UserDtoRecord userDtoRecord) {
        //Convert UserDto to User entity object JPA
        Optional<User> optionalUser = userRespository.findByEmail(userDtoRecord.email());
        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists for user");
        }

        User user = new User(userDtoRecord);
        User createdUser = userRespository.save(user);
        //Convert User entity object JPA to UserDto
        UserDtoRecord createdUserDto = new UserDtoRecord(createdUser);
        return createdUserDto;
    }
    @Override
    public UserDtoRecord getUserById(Long id){
        User user = userRespository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User","id", id)
        );// this is a lambda expression that is used to throw an exception if the user is not found
        //orElseThrow is a method that is used to throw an exception if the user is not found
        UserDtoRecord userDtoRecord = new UserDtoRecord(user);
        return userDtoRecord;
    }
    @Override
    public List<UserDtoRecord> getAllUsers(){
        List<User> allUsers = userRespository.findAll();
        List<UserDtoRecord> allUsersDtoRecords = allUsers.stream().map(UserDtoRecord::new).toList();
//        List<UserDto> allUsersDto = new ArrayList<>();
//        for(User user : allUsers) {
//            UserDto userDto = UserMapper.mapToUserDto(user);
//            allUsersDto.add(userDto);
//        }
        return allUsersDtoRecords;
    }
    @Override
    public UserDtoRecord updateUserById(UserDtoRecord userDtoRecord){
        User userByID = userRespository.findById(userDtoRecord.id()).orElseThrow(
                () -> new ResourceNotFoundException("User","id", userDtoRecord.id())
        );;
        userByID.setFirstName(userDtoRecord.firstName());
        userByID.setLastName(userDtoRecord.lastName());
        userByID.setEmail(userDtoRecord.email());
        userRespository.save(userByID);
        UserDtoRecord updatedUserDto = new UserDtoRecord(userByID);
        return updatedUserDto;
    }
    @Override
    public void deleteUserById(Long id){
        User userByID = userRespository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User","id", id)
        );;
        userRespository.deleteById(id);
    }

}
