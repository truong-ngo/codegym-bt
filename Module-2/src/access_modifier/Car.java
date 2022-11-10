package access_modifier;

public class Car {
    private String name;
    private String engine;
    private static int numberOfCars;

    public Car (String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }
}
