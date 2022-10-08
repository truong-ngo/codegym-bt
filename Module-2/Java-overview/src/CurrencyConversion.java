import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USD amount: ");
        double usd = scanner.nextDouble();
        double rateVndUsd = 23000;
        double vnd = usd * rateVndUsd;
        System.out.println(vnd);
    }
}