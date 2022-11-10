package design_pattern.demo.singleton;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerializationAndSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    private int value;
    private String name;

    private SerializationAndSingleton(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException("Value may not be less than 0");
        }
        this.value = value;
        this.name = name;
    }

    private static class SerializableSingletonHolder{
        public static final SerializationAndSingleton INSTANCE;
        static {
            INSTANCE = new SerializationAndSingleton(0, "default");
        }
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("proxy required");
    }

    private Object writeReplace(){
        return new SerializationProxy(this);
    }

    private static class SerializationProxy implements Serializable{
        private static final long serialVersionUID = 1L;
        public SerializationProxy(SerializationAndSingleton ignored) { } //Here is the question

        private Object readResolve(){
            return SerializableSingletonHolder.INSTANCE;
        }
    }
}
