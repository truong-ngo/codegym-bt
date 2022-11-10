package structural_design_pattern.demo.facade;

public class PointCartesian {
    private double x, y;

    public PointCartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
