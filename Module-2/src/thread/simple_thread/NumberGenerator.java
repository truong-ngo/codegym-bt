package thread.simple_thread;

public class NumberGenerator implements Runnable {
    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "\t" + hashCode());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
