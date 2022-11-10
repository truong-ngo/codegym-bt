package automated_testing_tdd.fizz_buzz;

public class FizzBuzzTranslate {

    public static String fizzBuzzTranslate(int number) {
        if (number >= 100) {
            return "Number >= 100";
        }
        int unit = number % 10;
        int tenth = number / 10;
        if ((isFizz(tenth) && isBuzz(unit)) || (isBuzz(tenth) && isFizz(unit))) {
            return "FizzBuzz";
        }
        if (isFizz(unit) || isFizz(tenth)) {
            return "Fizz";
        }
        if (isBuzz(unit) || isBuzz(tenth)) {
            return "Buzz";
        }
        return numberToString(tenth) + " " + numberToString(unit);
    }

    public static boolean isFizz(int number) {
        return (number == 3);
    }

    public static boolean isBuzz(int number) {
        return (number == 5);
    }

    public static String numberToString(int number) {
        String str = null;
        if (number < 10) {
            switch (number) {
                case 1:
                    str = "One";
                    break;
                case 2:
                    str = "Two";
                    break;
                case 3:
                    str = "Three";
                    break;
                case 4:
                    str = "Four";
                    break;
                case 5:
                    str = "Five";
                    break;
                case 6:
                    str = "Six";
                    break;
                case 7:
                    str = "Seven";
                    break;
                case 8:
                    str = "Eight";
                    break;
                case 9:
                    str = "Nine";
                    break;
                default:
                    str = "Zero";
            }
        }
        return str;
    }
}
