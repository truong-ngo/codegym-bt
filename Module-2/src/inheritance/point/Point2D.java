package inheritance.point;

public class Point2D {
    private float x,y;

    public Point2D() {

    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] xy = {getX(),getY()};
        return xy;
    }

    public void setXY(float x, float y) {
        setX(x);
        setY(y);
    }

    public String toString() {
        return "Point2D with x,y = (" + getX() + "," + getY() + ")";
    }
}
