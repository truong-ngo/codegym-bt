package com.example.jwt.service;

import com.example.jwt.model.Role;

public interface IRoleService extends IService<Role, Long> {
    Role findByName(String name);
}
