package design_pattern.demo.singleton;

public class ThreadSafeSingleton {
    private static final ThreadSafeSingleton instance = new ThreadSafeSingleton();

    private ThreadSafeSingleton() {

    }

    public static synchronized ThreadSafeSingleton getInstance () {
        return instance;
    }
}
