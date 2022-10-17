package extract_method;

public class Cylinder {

    public static double getVolume(double radius, double height) {
        double baseArea = getBaseArea(radius);
        double volume = baseArea * height;
        return volume;
    }

    public static double getBaseArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double getPerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}
