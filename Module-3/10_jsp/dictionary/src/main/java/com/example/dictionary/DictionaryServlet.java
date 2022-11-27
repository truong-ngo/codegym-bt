package com.example.dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "DictionaryServlet", value = "/dictionary")
public class DictionaryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> dic = new TreeMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");

        String search = request.getParameter("word");
        String result = dic.get(search);
        result = (result == null) ? "Not found" : result;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("result", result);
        requestDispatcher.forward(request, response);
    }
}