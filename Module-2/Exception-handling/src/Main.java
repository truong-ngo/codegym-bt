import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter number 2: ");
        int num2 = scanner.nextInt();
        try {
            int result = quotient(num1, num2);
            System.out.println(num1 + " / " + num2 + " = " + result);
        } catch (ArithmeticException exception) {
            System.out.println("Exception: an integer can not be divided by zero");
        }
        System.out.println("Execution continues ...");
    }

    public static int quotient(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Divisor can not be zero");
        } return num1 / num2;
    }
}