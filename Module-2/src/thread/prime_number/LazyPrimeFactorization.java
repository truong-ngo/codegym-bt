package thread.prime_number;

import static loop.Display20FirstPrimeNumbers.isPrimeNumber;

public class LazyPrimeFactorization implements Runnable {
    @Override
    public void run() {
        int number = 0;
        while (number < 1000) {
            if (isPrimeNumber(number)) {
                System.out.println("Lazy: " + number);
            }
            number++;
        }
    }
}
