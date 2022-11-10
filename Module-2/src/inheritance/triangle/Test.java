package inheritance.triangle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("blue",false);
        System.out.println(shape);
        System.out.println("----------");
        Scanner scanner = new Scanner(System.in);
        double side1 = 0,side2 = 0,side3 = 0;
        String color = "";
        boolean checkTriangle = false;
        do {
            System.out.println("Enter side 1 of triangle: ");
            side1 = scanner.nextDouble();
            System.out.println("Enter side 2 of triangle: ");
            side2 = scanner.nextDouble();
            System.out.println("Enter side 3 of triangle: ");
            side3 = scanner.nextDouble();
            scanner.nextLine();
            if (!(side1 > 0 && side2 > 0 && side3 > 0 && side1 + side2 > side3
                    && side1 + side3 > side2 && side2 + side3 > side1)) {
                System.out.println(side1 + "," + side2 + "," + side3 + " is not the sides of a triangle!");
            } else {
                checkTriangle = true;
            }
        } while (!checkTriangle);
        System.out.println("Enter color of triangle: ");
        color = scanner.nextLine();
        Triangle triangle = new Triangle(side1,side2,side3,color,true);
        System.out.println(triangle);
    }
}
