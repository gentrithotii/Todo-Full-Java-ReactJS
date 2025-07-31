package com.gentrit.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDTO {
    private String userName;
    private String password;

    public UserDTO(String userName, String password, UserDetailsDTO userDetailsDTO) {
        setUserName(userName);
        setPassword(password);

    }
}
