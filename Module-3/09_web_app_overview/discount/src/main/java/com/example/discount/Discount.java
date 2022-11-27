package com.example.discount;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "discount", value = "/discount")
public class Discount extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        double discountAmount = price * discount * 0.01;
        double priceAfterDiscount = price - discountAmount;

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<p>Discount amount: " + discountAmount + " </p>");
        out.println("<p>Price after discount: " + priceAfterDiscount + " </p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}