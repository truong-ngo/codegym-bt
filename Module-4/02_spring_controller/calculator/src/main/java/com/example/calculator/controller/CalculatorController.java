package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @PostMapping("/calculator")
    public ModelAndView calculator(Calculator calculator) {
        ModelAndView modelAndView = new ModelAndView("index");
        String operandOne = calculator.getOperand_one();
        String operandTwo = calculator.getOperand_two();
        String operator = calculator.getOperator();
        String result = null;
        double res;
        switch (operator) {
            case "add":
                res = Double.parseDouble(operandOne) + Double.parseDouble(operandTwo);
                result = Double.toString(res);
                break;
            case "sub":
                res = Double.parseDouble(operandOne) - Double.parseDouble(operandTwo);
                result = Double.toString(res);
                break;
            case "mul":
                res = Double.parseDouble(operandOne) * Double.parseDouble(operandTwo);
                result = Double.toString(res);
                break;
            case "div":
                try {
                    res = Double.parseDouble(operandOne) / Double.parseDouble(operandTwo);
                    result = Double.toString(res);
                } catch (Exception exception) {
                    result = "Cannot divide by zero";
                }
                break;
        }
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
