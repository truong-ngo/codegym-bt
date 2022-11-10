package abtract_class_interface.interface_resizeable;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2,"green",true);
        shapes[1] = new Rectangle(3,4,"red",false);
        shapes[2] = new Square(5,"blue",true);
        System.out.println("Pre-resize");
        for (Shape shape : shapes) {
            System.out.println(shape);
            shape.resize(200);
        }
        System.out.println("After-resize");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
