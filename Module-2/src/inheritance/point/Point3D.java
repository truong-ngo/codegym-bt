package inheritance.point;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {

    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] xyz = {getXY()[1],getXY()[2],getZ()};
        return xyz;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x,y);
        setZ(z);
    }

    @Override
    public String toString() {
        return "Point3D with z = " + getZ() + ", which is a subclass of " + super.toString();
    }
}
