package thread.odd_even;

public class EvenThread extends Thread {
    @Override
    public void run() {
        System.out.println("Even number");
        try {
            for (int i = 0; i <= 10; i += 2) {
                System.out.println(i);
                Thread.sleep(15);
            }
        } catch (InterruptedException exception) {
            System.out.println("Thread interrupted");
        }
    }
}
