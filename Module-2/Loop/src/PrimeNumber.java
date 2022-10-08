import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = scanner.nextInt();
        boolean checkPrimeNumber = true;
        if (number < 2) {
            checkPrimeNumber = false;
        } else if (number > 2) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    checkPrimeNumber = false;
                    break;
                }
            }
        }
        if (checkPrimeNumber) {
            System.out.println("Number '" + number + "' is a prime number!");
        } else {
            System.out.println("Number '" + number + "' is not a prime number!");
        }
    }
}
