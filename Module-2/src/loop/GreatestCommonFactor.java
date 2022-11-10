package loop;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number a: ");
        int a = scanner.nextInt();
        System.out.println("Enter number b: ");
        int b = scanner.nextInt();
        int gcf = 0;
        if (a == 0 && b == 0) {
            System.out.println("No greatest common factor");
        } else {
            for (int i = 1; i <= Math.max(a,b); i++) {
                if (a % i == 0 && b % i == 0) {
                    gcf = i;
                }
            }
            System.out.println("Greatest common factor of a and b is: " + gcf);
        }
    }
}
