package interface_compareable;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {

    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle circle) {
        if (getRadius() < circle.getRadius()) return -1;
        else if (getRadius() > circle.getRadius()) return 1;
        else return 0;
    }
}
