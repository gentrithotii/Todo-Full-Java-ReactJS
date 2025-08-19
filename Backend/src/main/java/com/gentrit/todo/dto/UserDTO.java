package com.gentrit.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDTO {
    private String username;
    private String password;

    public UserDTO(String username, String password, UserDetailsDTO userDetailsDTO) {
        setUsername(username);
        setPassword(password);

    }
}
