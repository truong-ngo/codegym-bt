package class_and_object;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Rectangle
        System.out.println("Rectangle:");
        System.out.println("Enter the width: ");
        double width = scanner.nextDouble();
        System.out.println("Enter the height: ");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width,height);
        System.out.println("Your Rectangle \n" + rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
        System.out.println("----------");

        // Quadratic Equation
        System.out.println("Quadratic Equation: ");
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a,b,c);
        if (a == 0) {
            System.out.println("This is Linear Equation!");
        } else if (equation.getDiscriminant() < 0) {
            System.out.println("The equation has no real roots");
        } else if (equation.getDiscriminant() == 0) {
            System.out.println("The equation has double root: x = " + equation.getRoot1());
        } else {
            System.out.println("The equation has two root: x1 = " + equation.getRoot1() + " and x2 = " + equation.getRoot2());
        }
        System.out.println("----------");

        // Stop Watch

        System.out.println("Stop Watch: ");
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = (int)(Math.random()*100);
        }
        LocalTime start = LocalTime.now();
        selectionSort(array);
        LocalTime end = LocalTime.now();
        StopWatch stopWatch = new StopWatch(start,end);
        System.out.println("Time: " + stopWatch.getElapsedTime());
        System.out.println("----------");

        // Fan
        System.out.println("Fan: ");
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.getFAST());
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOnOff(true);
        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.getMEDIUM());
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOnOff(false);
        System.out.println(fan1);
        System.out.println(fan2);
    }
    public static void selectionSort(int...a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[j] < a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
