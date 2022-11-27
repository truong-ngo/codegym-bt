package com.example.dictionary;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "translate", value = "/translate")
public class Dictionary extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new TreeMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String search = request.getParameter("txtSearch");
        String result = dictionary.get(search);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (result != null) {
            out.println("<p>Word: " + search + "</p>");
            out.println("<p>Result: " + result + "</p>");
        } else {
            out.println("<p>Not found</p>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}