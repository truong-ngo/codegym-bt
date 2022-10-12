package movable_point;

public class MovablePoint extends Point {
    private float xSpeed,ySpeed;

    public MovablePoint() {

    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speed = {getXSpeed(),getYSpeed()};
        return speed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    }

    @Override
    public String toString() {
        return "Movable point with speed = ("
                + xSpeed + "," + ySpeed + ")"
                + ", which is a subclass of "
                + super.toString();
    }

    public MovablePoint move() {
        float x = getX() + xSpeed;
        float y = getY() + ySpeed;
        setXY(x,y);
        return this;
    }
}
