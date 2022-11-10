package design_pattern.shape;

public class ShapeFactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.getShape("circle");
        Shape square = factory.getShape("square");
        Shape rectangle = factory.getShape("rectangle");
        circle.draw();
        square.draw();
        rectangle.draw();
    }
}
