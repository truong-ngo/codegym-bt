package loop;

public class DisplayPrimeNumbersLessThan100 {
    public static void main(String[] args) {
        for (int number = 0; number < 100; number++) {
            if (Display20FirstPrimeNumbers.isPrimeNumber(number)) {
                System.out.println(number);
            }
        }
    }
}
