package com.example.backend.service.core;

import com.example.backend.model.User;
import com.example.backend.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IService<User, Long>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
