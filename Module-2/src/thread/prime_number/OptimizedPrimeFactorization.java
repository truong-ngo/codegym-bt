package thread.prime_number;

import static loop.Display20FirstPrimeNumbers.isPrimeNumber;

public class OptimizedPrimeFactorization implements Runnable {

    @Override
    public void run() {
        int number = 0;
        while (number < 1000) {
            if (isPrimeNumber(number)) {
                System.out.println("Optimize: " + number);
            }
            number++;
        }
    }

    public boolean isPrimeNumberOptimize(int number) {
        boolean check = true;
        if (number < 2) {
            check = false;
        } else if (number > 2) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
}
