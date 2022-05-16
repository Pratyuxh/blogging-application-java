package com.example.blogdemo.services;

import com.example.blogdemo.payloads.UserDto;
import com.example.blogdemo.entities.User;
import java.util.List;

public interface UserService {

    UserDto registerNewUser(UserDto user);
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}




