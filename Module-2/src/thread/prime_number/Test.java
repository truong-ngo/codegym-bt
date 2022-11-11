package thread.prime_number;

public class Test {
    public static void main(String[] args) {
        LazyPrimeFactorization lazy = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimize = new OptimizedPrimeFactorization();
        Thread thread1 = new Thread(lazy);
        Thread thread2 = new Thread(optimize);
        thread1.start();
        thread2.start();
    }
}
