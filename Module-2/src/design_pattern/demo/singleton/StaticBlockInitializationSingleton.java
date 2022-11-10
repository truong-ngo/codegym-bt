package design_pattern.demo.singleton;

public class StaticBlockInitializationSingleton {
    private static final StaticBlockInitializationSingleton instance;

    private StaticBlockInitializationSingleton() {

    }

    static {
        instance = new StaticBlockInitializationSingleton();
    }

    public static StaticBlockInitializationSingleton getInstance() {
        return instance;
    }
}
