package com.gentrit.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRegisterDTO {
    private String userName;
    private String password;
    private UserDetailsDTO userDetailsDTO;

    public UserRegisterDTO(String userName, String password, UserDetailsDTO userDetailsDTO) {
    setUserName(userName);
    setPassword(password);
    setUserDetailsDTO(userDetailsDTO);
    }

}
