package loop;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money, month, interestRate;
        System.out.println("Enter money: ");
        money = scanner.nextDouble();
        System.out.println("Enter month: ");
        month = scanner.nextDouble();
        System.out.println("Enter interest rate (year): ");
        interestRate = scanner.nextDouble();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * ((interestRate / 100) /12) * month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
