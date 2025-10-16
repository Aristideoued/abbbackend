package com.abb.abb.service;

import java.util.List;

import com.abb.abb.dto.UserDto;
import com.abb.abb.dto.UserRequest;

public interface UserService {
    UserDto createUser(UserRequest request);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserRequest request);

    void deleteUser(Long id);
}