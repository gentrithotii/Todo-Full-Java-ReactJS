package com.gentrit.todo.repository;

import com.gentrit.todo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByUserNameContainsIgnoreCase(String userName);
    
    

}
