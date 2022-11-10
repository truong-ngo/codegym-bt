package thread.runnable_demo;

public class RunnableDemo implements Runnable {
    private Thread thread;
    private final String THREAD_NAME;

    public RunnableDemo(String name) {
        THREAD_NAME = name;
        System.out.println("Creating " + THREAD_NAME);
    }

    public void run() {
        System.out.println("Running " + THREAD_NAME);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + THREAD_NAME + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException exception) {
            System.out.println("Thread " + THREAD_NAME + " interrupted.");
        }
        System.out.println("Thread " + THREAD_NAME + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + THREAD_NAME);
        if (thread == null) {
            thread = new Thread(this, THREAD_NAME);
            thread.start();
        }
    }
}

