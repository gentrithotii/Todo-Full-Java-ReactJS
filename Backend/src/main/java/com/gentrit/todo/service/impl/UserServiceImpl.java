package com.gentrit.todo.service.impl;

import com.gentrit.todo.dto.UserDetailsDTO;
import com.gentrit.todo.dto.UserRegisterDTO;
import com.gentrit.todo.entity.User;
import com.gentrit.todo.entity.UserDetails;
import com.gentrit.todo.repository.UserDetailsRepository;
import com.gentrit.todo.repository.UserRepository;
import com.gentrit.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public Optional<UserRegisterDTO> registerUser(UserRegisterDTO userDTO) {
        UserDetails details = new UserDetails(userDTO.getUserDetailsDTO().getFirstName(), userDTO.getUserDetailsDTO().getLastName(), userDTO.getUserDetailsDTO().getEmail(), userDTO.getUserDetailsDTO().getSex());
        User user = new User(userDTO.getUserName(), userDTO.getPassword(), details);

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
}
