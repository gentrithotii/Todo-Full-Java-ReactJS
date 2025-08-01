package com.gentrit.todo.service.impl;

import com.gentrit.todo.dto.UserRegisterDTO;
import com.gentrit.todo.entity.User;
import com.gentrit.todo.entity.UserDetails;
import com.gentrit.todo.repository.UserRepository;
import com.gentrit.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {
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
        User user = new User(userDTO.getUserName(), getBcryptPasswordEncoder.encode(userDTO.getPassword()), details);


        userRepository.save(user);

        return Optional.of(userDTO);
    }

    @Override
    public List<UserRegisterDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public boolean deleteUser(UserRegisterDTO user) {
        return false;
    }

    @Override
    public Optional<UserRegisterDTO> updateUser(UserRegisterDTO user) {
        return Optional.empty();
    }


    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserNameContainsIgnoreCase(username).orElseThrow(() ->  new UsernameNotFoundException("User not found with this email" +  username));

        //Todo Implement roles admin and user and so on
        return withUsername(user.getUserName()).password(user.getPassword()).build();
    }
}
