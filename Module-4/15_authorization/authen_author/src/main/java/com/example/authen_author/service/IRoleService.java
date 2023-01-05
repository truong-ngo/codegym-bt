package com.example.authen_author.service;

import com.example.authen_author.model.Role;

public interface IRoleService extends IService<Role, Long> {
    Role findByName(String name);
}
