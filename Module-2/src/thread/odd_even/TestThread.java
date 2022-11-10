package thread.odd_even;

public class TestThread {
    public static void main(String[] args) {
        try {
            OddThread oddThread = new OddThread();
            EvenThread evenThread = new EvenThread();
            oddThread.start();
            oddThread.join();
            evenThread.start();
        } catch (InterruptedException exception) {
            System.out.println("Thread interrupted");
        }
    }
}
