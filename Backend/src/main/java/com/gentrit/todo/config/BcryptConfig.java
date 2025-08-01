package com.gentrit.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BcryptConfig {

    @Bean
    public BCryptPasswordEncoder getBcryptPasswordEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        return encoder;
    }
}
