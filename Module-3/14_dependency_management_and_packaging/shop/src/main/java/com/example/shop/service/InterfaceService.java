package com.example.shop.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceService<E> {
    void create(HttpServletRequest request);
    void render(HttpServletRequest request, List<E> lists);
    void update(HttpServletRequest request);
    void delete(HttpServletRequest request);
}
