package class_and_object;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    public Fan() {};

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setOnOff(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public String toString() {
        String str = "";
        if (isOn()) {
            str += "Fan is on\n";
            str += "Speed: " + this.speed + "\n";
        } else {
            str += "Fan is off\n";
        }
        str += ("Color: " + this.color + "\n");
        str += ("Radius: " + this.radius + "\n");
        return str;
    }
}
