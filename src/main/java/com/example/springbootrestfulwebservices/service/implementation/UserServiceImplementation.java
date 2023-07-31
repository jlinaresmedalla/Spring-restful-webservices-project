package com.example.springbootrestfulwebservices.service.implementation;

import com.example.springbootrestfulwebservices.dto.UserDtoRecord;
import com.example.springbootrestfulwebservices.entity.User;
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
        User user = new User(userDtoRecord);
        User createdUser = userRespository.save(user);
        //Convert User entity object JPA to UserDto
        UserDtoRecord createdUserDto = new UserDtoRecord(createdUser);
        return createdUserDto;
    }
    @Override
    public UserDtoRecord getUserById(Long id){
        User user = userRespository.findById(id).get();
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
    public UserDtoRecord updateUserById(Long id, UserDtoRecord userDtoRecord){
        User userByID = userRespository.findById(id).get();
        userByID.setFirstName(userDtoRecord.firstName());
        userByID.setLastName(userDtoRecord.lastName());
        userByID.setEmail(userDtoRecord.email());
        userRespository.save(userByID);
        UserDtoRecord updatedUserDto = new UserDtoRecord(userByID);
        return updatedUserDto;
    }
    @Override
    public void deleteUserById(Long id){
        userRespository.deleteById(id);
    }

}
