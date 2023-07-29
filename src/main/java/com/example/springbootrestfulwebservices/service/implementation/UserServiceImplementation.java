package com.example.springbootrestfulwebservices.service.implementation;

import com.example.springbootrestfulwebservices.entity.User;
import com.example.springbootrestfulwebservices.repository.UserRespository;
import com.example.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    //@Autowired This is not needed because we have @AllArgsConstructor, also we are using constructor injection
    //instead of field injection which is a better practice and this class has only one attribute or argument in the constructor
    private UserRespository userRespository;

    @Override
    public User createUser(User user) {
        return userRespository.save(user);
    }
    @Override
    public User getUserById(Long id){
        return userRespository.findById(id).get();
    }
    @Override
    public List<User> getAllUsers(){
        return userRespository.findAll();
    }
    @Override
    public User updateUserById(Long id, User user){
        User userByID = userRespository.findById(id).get();
        userByID.setFirstName(user.getFirstName());
        userByID.setLastName(user.getLastName());
        userByID.setEmail(user.getEmail());
        return userRespository.save(userByID);
    }
    @Override
    public void deleteUserById(Long id){
        userRespository.deleteById(id);
    }



}
