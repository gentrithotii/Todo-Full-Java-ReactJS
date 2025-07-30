package com.gentrit.todo.entity;

import com.gentrit.todo.types.Gender;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class UserDetails {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 25)
    private String firstName;

    @Column(length = 25)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender sex;

    @OneToOne(mappedBy = "details")
    private User user;

    public UserDetails(String firstName, String lastName, String email, Gender sex){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setSex(sex);
    }

}
