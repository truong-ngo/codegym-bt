public class Circle {
    private double radius = 1.0d;
    private String color = "red";

    Circle() {};

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius,2);
    }
}
