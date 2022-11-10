package design_pattern.demo.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {
    public static void main(String[] args) {
        EagerInitializationSingleton instanceOne = EagerInitializationSingleton.getInstance();
        EagerInitializationSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializationSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializationSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
