package abtract_class_interface.interface_colorable;

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
    public String toString() {
        return "A Square with side = "
                + this.getSize()
                + ", which is a subclass of "
                + super.toString();
    }

    public void howToColor() {
        System.out.println("Color 4 side");
    }
}
