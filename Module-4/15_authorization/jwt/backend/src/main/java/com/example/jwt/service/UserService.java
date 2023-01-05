package com.example.jwt.service;

import com.example.jwt.entities.User;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    public static List<User> users = new ArrayList<>();
    static {
        User userKai = new User(1L, "kai", "123456");
        userKai.setRoles(new String[] { "ROLE_ADMIN" });
        User userSena = new User(2L, "sena", "123456");
        userSena.setRoles(new String[] { "ROLE_USER" });
        users.add(userKai);
        users.add(userSena);
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Long id) {
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    public boolean add(User user) {
        for (User userExist : users) {
            if (Objects.equals(user.getId(), userExist.getId()) || StringUtils.equals(user.getUsername(), userExist.getUsername())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public void delete(Long id) {
        users.removeIf(user -> Objects.equals(user.getId(), id));
    }

    public User loadUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkLogin(User user) {
        for (User userExist : users) {
            if (StringUtils.equals(user.getUsername(), userExist.getUsername())
                && StringUtils.equals(user.getPassword(), userExist.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
