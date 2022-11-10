package thread.odd_even;

import java.util.Map;

public class OddThread extends Thread {
    @Override
    public void run() {
        System.out.println("Odd number");
        try {
            for (int i = 1; i < 10; i += 2) {
                System.out.println(i);
                Thread.sleep(10);
            }
        } catch (InterruptedException exception) {
            System.out.println("Thread interrupted");
        }
    }
}
