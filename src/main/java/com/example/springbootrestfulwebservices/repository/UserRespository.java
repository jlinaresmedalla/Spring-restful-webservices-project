package com.example.springbootrestfulwebservices.repository;

import com.example.springbootrestfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRespository extends JpaRepository<User, Long>{

}
