package fizz_buzz;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = input.nextInt();
        String result = FizzBuzz.fizzBuzz(number);
        System.out.println(result);
    }
}
