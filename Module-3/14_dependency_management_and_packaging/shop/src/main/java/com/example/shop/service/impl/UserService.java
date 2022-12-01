package com.example.shop.service.impl;

import com.example.shop.dao.impl.UserDAO;
import com.example.shop.model.User;
import com.example.shop.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private static UserService instance;

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    @Override
    public void create(HttpServletRequest request) {

    }

    @Override
    public void render(HttpServletRequest request, List<User> lists)  {

    }

    @Override
    public void update(HttpServletRequest request) {

    }

    @Override
    public void delete(HttpServletRequest request)  {

    }

    @Override
    public User checkUser(HttpServletRequest request)  {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> users = null;
        try {
            users = UserDAO.getInstance().selectAll();
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
