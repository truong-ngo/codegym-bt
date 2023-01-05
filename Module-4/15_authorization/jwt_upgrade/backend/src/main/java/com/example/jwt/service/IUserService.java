package com.example.jwt.service;

import com.example.jwt.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IService<User, Long>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
