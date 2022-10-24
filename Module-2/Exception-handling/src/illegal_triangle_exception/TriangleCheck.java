package illegal_triangle_exception;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleCheck {
    public static void checkTriangle(int a, int b, int c) throws IllegalTriangleException {
        boolean isTriangle = (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a);
        if (!isTriangle) {
            throw new IllegalTriangleException("Invalid Triangle");
        } else {
            System.err.println("Valid triangle");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter side a of triangle: ");
            int sideA = scanner.nextInt();
            System.out.println("Enter side b of triangle: ");
            int sideB = scanner.nextInt();
            System.out.println("Enter side c of triangle: ");
            int sideC = scanner.nextInt();
            checkTriangle(sideA, sideB, sideC);
        } catch (InputMismatchException exception) {
            System.out.println("Invalid input");
        } catch (Exception exception) {
            System.err.println("Triangle exception occur: ");
        }
    }
}
