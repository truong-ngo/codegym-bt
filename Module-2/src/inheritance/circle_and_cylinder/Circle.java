package inheritance.circle_and_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle() {

    }

    public Circle (double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter() {
        return Math.PI * 2 * this.radius;
    }

    public String toString() {
        return "A Circle with radius = " + getRadius() + " with color of " + getColor();
    }
}
