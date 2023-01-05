package com.example.authen_author.service;

import com.example.authen_author.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IService<User, Long>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
