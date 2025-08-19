package com.gentrit.todo.service.impl;

import com.gentrit.todo.dto.UserRegisterDTO;
import com.gentrit.todo.entity.User;
import com.gentrit.todo.entity.UserDetails;
import com.gentrit.todo.repository.UserRepository;
import com.gentrit.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder getBcryptPasswordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder getBcryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.getBcryptPasswordEncoder = getBcryptPasswordEncoder;
    }

    @Override
    public Optional<UserRegisterDTO> registerUser(UserRegisterDTO userDTO) {
        UserDetails details = new UserDetails(userDTO.getUserDetailsDTO().getFirstName(), userDTO.getUserDetailsDTO().getLastName(), userDTO.getUserDetailsDTO().getEmail(), userDTO.getUserDetailsDTO().getSex());
        User user = new User(userDTO.getUsername(), getBcryptPasswordEncoder.encode(userDTO.getPassword()), details);


        userRepository.save(user);

        return Optional.of(userDTO);
    }

    @Override
    public List<UserRegisterDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public Optional<User> findByUserNameContains(String username) {
        User user = userRepository.findUserByUsernameContainsIgnoreCase(username).orElseThrow(null);
        return  Optional.of(user);
    }

    @Override
    public boolean deleteUser(UserRegisterDTO user) {
        return false;
    }

    @Override
    public Optional<UserRegisterDTO> updateUser(UserRegisterDTO user) {
        return Optional.empty();
    }


}
