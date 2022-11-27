package com.example.simple_calculator;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        float firstOperand = Float.parseFloat(request.getParameter("first-operand"));
        float secondOperand = Float.parseFloat(request.getParameter("second-operand"));
        String operator = request.getParameter("operator");
        float result = 0;
        String mess  = "";
        switch (operator) {
            case "add":
                result = firstOperand + secondOperand;
                break;
            case "sub":
                result = firstOperand - secondOperand;
                break;
            case "mul":
                result = firstOperand * secondOperand;
                break;
            case "div":
               result = firstOperand / secondOperand;
               if (secondOperand == 0) {
                   result = Float.NaN;
                   mess = "Can not divide by zero";
               }
               break;
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("result", result);
        request.setAttribute("mess", mess);
        requestDispatcher.forward(request, response);
    }
}