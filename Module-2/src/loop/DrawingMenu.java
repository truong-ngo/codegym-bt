package loop;

import java.util.Scanner;

public class DrawingMenu {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu:");
            System.out.println("1. Draw a triangle");
            System.out.println("2. Draw a square");
            System.out.println("3. Draw a rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw a triangle");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 6-i; j > 0; j--) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("Draw a square");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("Draw a rectangle");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 6; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
