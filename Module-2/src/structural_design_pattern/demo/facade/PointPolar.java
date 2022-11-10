package structural_design_pattern.demo.facade;

public class PointPolar {
    private double radius, angle;

    public PointPolar(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public void rotate(int angle) {
        this.angle += angle % 360;
    }

    public String toString() {
        return "[" + radius + "@" + angle + "]";
    }
}
