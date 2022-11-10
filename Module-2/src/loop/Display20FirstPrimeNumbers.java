package loop;

import java.util.Scanner;

public class Display20FirstPrimeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers of Prime numbers: ");
        int numbers = input.nextInt();
        int count = 0;
        int n = 2;
        while (count < numbers) {
            if (isPrimeNumber(n)) {
                System.out.println(n);
                n++; count++;
            } else {
                n++;
            }
        }
    }
    public static boolean isPrimeNumber(int number) {
        boolean checkFlag = true;
        if (number < 2) {
            checkFlag = false;
        } else if (number > 2) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    checkFlag = false;
                    break;
                }
            }
        }
        return checkFlag;
    }
}
