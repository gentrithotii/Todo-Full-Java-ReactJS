package com.gentrit.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRegisterDTO {
    private String username;
    private String password;
    private UserDetailsDTO userDetailsDTO;

    public UserRegisterDTO(String username, String password, UserDetailsDTO userDetailsDTO) {
    setUsername(username);
    setPassword(password);
    setUserDetailsDTO(userDetailsDTO);
    }

}
