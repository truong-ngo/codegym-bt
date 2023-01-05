package com.example.cart_complete.service.core;

import com.example.cart_complete.model.User;
import com.example.cart_complete.service.IService;

public interface IUserService extends IService<User, Long> {
    User findByUsername(String username);
}
