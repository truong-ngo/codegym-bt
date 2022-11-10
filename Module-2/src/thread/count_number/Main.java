package thread.count_number;

public class Main {
    public static void main(String[] args) {
        Count count = new Count();
        try {
            while (count.getMyThread().isAlive()) {
                System.out.println("Main thread will be alive till the child thread is live");
                Thread.sleep(1500);
            }
        } catch (InterruptedException exception) {
            System.out.println("My thread interrupted");
        }
        System.out.println("Main thread run is over");
    }
}
