package com.gentrit.todo.dto;

import com.gentrit.todo.types.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDetailsDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Gender sex;

    public UserDetailsDTO(String firstName, String lastName, String email, Gender sex){
    setFirstName(firstName);
    setLastName(lastName);
    setEmail(email);
    setSex(sex);
    }


}
