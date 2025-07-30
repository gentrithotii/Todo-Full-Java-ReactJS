package com.gentrit.todo.service;

import com.gentrit.todo.dto.UserDetailsDTO;
import com.gentrit.todo.dto.UserRegisterDTO;
import com.gentrit.todo.entity.User;
import com.gentrit.todo.entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserRegisterDTO> registerUser(UserRegisterDTO user);
    List<UserRegisterDTO> getAllUsers();
    boolean deleteUser(UserRegisterDTO user);
    Optional<UserRegisterDTO> updateUser(UserRegisterDTO user);
}
