package com.example.user_manager.controller;

import com.example.user_manager.dao.UserDAO;
import com.example.user_manager.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                // searchProduct(request, response);
                break;
            case "view":
                try {
                    listUsers(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "permission":
                try {
                    addUserPermission(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "test-without-tran":
                try {
                    testWithoutTran(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "test-use-tran":
                try {
                    testUseTran(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "test":
                try {
                    test(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createUser(request, response);
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
                break;
            case "edit":
                try {
                    updateUser(request, response);
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
                break;
            case "view":
                try {
                    listUsers(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                search(request, response);
                break;
            case "sort":
                try {
                    sort(request, response);
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
                break;
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> users = userDAO.selectAllStored();
        String username = request.getParameter("username");
        request.setAttribute("users", users);
        request.setAttribute("username", username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/user.jsp");
        requestDispatcher.forward(request, response);
    }

    public void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> users = userDAO.selectAll();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        int id = users.get(users.size() - 1).getId() + 1;
        //userDAO.insert(new User(id, name, email, country));
        userDAO.insertStored(new User(id, name, email, country));
        listUsers(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(id, name, email, country);
        userDAO.updateStored(id, newUser);
        listUsers(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteStored(id);
        listUsers(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> searchList = new ArrayList<>();
        List<User> users = userDAO.selectAll();
        String search = request.getParameter("search").toLowerCase();
        String username = request.getParameter("username");
        String searchItem = request.getParameter("search-item");
        switch (searchItem) {
            case "name":
                for (User user : users) {
                    if (user.getName().toLowerCase().contains(search)) {
                        searchList.add(user);
                    }
                }
                break;
            case "country":
                for (User user : users) {
                    if (user.getCountry().toLowerCase().contains(search)) {
                        searchList.add(user);
                    }
                }
                break;
        }

        request.setAttribute("users", searchList);
        request.setAttribute("username", username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/user.jsp");
        requestDispatcher.forward(request, response);
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> sortList = new ArrayList<>();
        String username = request.getParameter("username");
        String sortItem = request.getParameter("sort-item");
        switch (sortItem) {
            case "name":
                sortList = userDAO.sort("name");
                break;
            case "country":
                sortList = userDAO.sort("country");
                break;
        }

        request.setAttribute("users", sortList);
        request.setAttribute("username", username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/user.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        int[] permission = {1, 2, 4};
        userDAO.addUserTransaction(user, permission);

    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        userDAO.insertUpdateWithoutTransaction();
    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        userDAO.insertUpdateUseTransaction();
    }

    private void test (HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        userDAO.testTransaction(user);
    }
}
