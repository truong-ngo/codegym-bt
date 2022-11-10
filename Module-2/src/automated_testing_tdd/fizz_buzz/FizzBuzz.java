package automated_testing_tdd.fizz_buzz;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        if (isFizzBuzz(number)) {
            return "FizzBuzz";
        }
        if (isFizz(number)) {
            return "Fizz";
        }
        if (isBuzz(number)) {
            return "Buzz";
        }
        return number + "";
    }

    public static boolean isFizz(int number) {
        return (number % 3 == 0);
    }

    public static boolean isBuzz(int number) {
        return (number % 5 == 0);
    }

    public static boolean isFizzBuzz(int number) {
        return (isFizz(number) && isBuzz(number));
    }
}
