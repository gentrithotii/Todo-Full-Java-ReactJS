package com.gentrit.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(length = 50, nullable = false, unique = true, updatable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( nullable = false)
    private UserDetails details;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Todo> todos = new ArrayList<>();


public User(String userName, String password, UserDetails details){
    setUserName(userName);
    setPassword(password);
    setDetails(details);
}


}
