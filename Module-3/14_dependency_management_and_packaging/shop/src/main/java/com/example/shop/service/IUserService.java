package com.example.shop.service;

import com.example.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public interface IUserService extends InterfaceService<User> {
    User checkUser(HttpServletRequest request);
}
