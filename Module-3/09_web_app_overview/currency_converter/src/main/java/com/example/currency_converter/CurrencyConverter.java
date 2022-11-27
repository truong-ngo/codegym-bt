package com.example.currency_converter;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CurrencyConverter", value = "/currency-converter")
public class CurrencyConverter extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        float vnd = usd * rate;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<h1>Rate: " + rate + "</h1>");
        out.println("<h1>USD: " + usd + "</h1>");
        out.println("<h1>VND: " + vnd + "</h1>");
        out.println("</html>");
    }

    public void destroy() {
    }
}