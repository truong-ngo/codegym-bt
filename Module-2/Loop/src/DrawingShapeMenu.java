import java.util.Scanner;

public class DrawingShapeMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Draw the isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choices = input.nextInt();
            switch (choices) {
                case 1:
                    System.out.println("Draw a rectangle:");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Draw a square triangle:");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 5-i; j > 0; j--) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }

                    for (int i = 0; i <= 5; i++) {
                        for (int j = i; j < 5; j++) {
                            System.out.print("  ");
                        }
                        for (int j = 5-i; j < 5; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    System.out.println();

                    for (int i = 0; i <= 5; i++) {
                        for (int j = 5-i; j < 5; j++) {
                            System.out.print("  ");
                        }
                        for (int j = i; j < 5; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }

                    for (int i = 0; i <= 5; i++) {
                        for (int j = 5-i; j < 5; j++) {
                            System.out.print("* ");
                        }
                        for (int j = i; j < 5; j++) {
                            System.out.print("  ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Draw the isosceles triangle:");
                    for (int i = 0; i <= 5; i++) {
                        for (int j = i; j < 5; j++) {
                            System.out.print("  ");
                        }
                        for (int j = 5-i; j < 5; j++) {
                            System.out.print("  * ");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice");
            }
        }
    }
}
