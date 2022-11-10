package clean_code.extract_variable_constant;

public class CalculatorTest {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';
    void testCalculateAdd() {
        int firstOperand = 1;
        int secondOperand = 1;
        char operator = ADDITION;
        int result = Calculator.calculate(firstOperand, secondOperand, operator);
    }

    void testCalculateSub() {
        int firstOperand = 2;
        int secondOperand = 1;
        char operator = SUBTRACTION;
        int result = Calculator.calculate(firstOperand, secondOperand, operator);
    }

    void testCalculateMul() {
        int firstOperand = 2;
        int secondOperand = 2;
        char operator = MULTIPLICATION;
        int result = Calculator.calculate(firstOperand, secondOperand, operator);
    }

    void testCalculateDiv() {
        int firstOperand = 6;
        int secondOperand = 3;
        char operator = DIVISION;
        int result = Calculator.calculate(firstOperand, secondOperand, operator);
    }
}
