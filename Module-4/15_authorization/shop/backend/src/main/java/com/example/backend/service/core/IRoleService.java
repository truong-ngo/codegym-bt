package com.example.backend.service.core;

import com.example.backend.model.Role;
import com.example.backend.service.IService;

public interface IRoleService extends IService<Role, Long> {
    Role findByName(String name);
}
