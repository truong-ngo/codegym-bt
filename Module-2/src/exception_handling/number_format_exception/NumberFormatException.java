package exception_handling.number_format_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberFormatException {
    public static void main(String[] args) {
        boolean checkFlag;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter x: ");
                int x = scanner.nextInt();
                System.out.println("Enter y: ");
                int y = scanner.nextInt();
                NumberFormatException calc = new NumberFormatException();
                calc.calculate(x, y);
                checkFlag = true;
            } catch (InputMismatchException exception) {
                System.err.println("Input is not a number");
                checkFlag = false;
            }
        } while (!checkFlag);

    }

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Addition x + y = " + a);
            System.out.println("Subtraction x - y = " + b);
            System.out.println("Multiplication x * y = " + c);
            System.out.println("Division x / y = " + d);
        } catch (Exception exception) {
            System.err.println("Exception Occur: " + exception.getMessage());
        }
    }
}
