package com.example.calculator.model;

public class Calculator {
    private String operand_one;
    private String operand_two;
    private String operator;

    public Calculator(String operand_one, String operand_two, String operator) {
        this.operand_one = operand_one;
        this.operand_two = operand_two;
        this.operator = operator;
    }

    public String getOperand_one() {
        return operand_one;
    }

    public void setOperand_one(String operand_one) {
        this.operand_one = operand_one;
    }

    public String getOperand_two() {
        return operand_two;
    }

    public void setOperand_two(String operand_two) {
        this.operand_two = operand_two;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
