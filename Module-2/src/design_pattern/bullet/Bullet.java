package design_pattern.bullet;

public class Bullet {
    public static int count = 0;
    private int position;

    public Bullet() {
        count++;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move() {
        position++;
    }
}
