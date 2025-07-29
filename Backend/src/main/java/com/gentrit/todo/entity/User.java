package com.gentrit.todo.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(length = 50, nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "details_id", nullable = false)
    private UserDetails details;

    @Setter(AccessLevel.NONE)
    private List<Todo> todos;



}
