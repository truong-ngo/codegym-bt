package inheritance.shapes;

public class Square extends Rectangle {
    public Square() {

    }
    public Square(double size) {
        super(size,size);
    }

    public Square(double size, String color, boolean filled) {
        super(size,size,color,filled);
    }

    public double getSize() {
        return this.getWidth();
    }

    public void setSize(double size) {
        this.setWidth(size);
        this.setLength(size);
    }

    @Override
    public void setWidth(double width) {
        this.setSize(width);
    }

    @Override
    public void setLength(double length) {
        this.setSize(length);
    }

    @Override
    public String toString() {
        return "A Square with side = "
                + this.getSize()
                + ", which is a subclass of "
                + super.toString();
    }
}
