package shapes;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red",false);
        System.out.println(shape);
        System.out.println("-----------");
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(3);
        System.out.println(circle);
        circle = new Circle(4,"indigo",false);
        System.out.println(circle);
        System.out.println("-----------");
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle(2,4);
        System.out.println(rectangle);
        rectangle = new Rectangle(3,6,"orange",true);
        System.out.println(rectangle);
        System.out.println("-----------");
        Square square = new Square();
        System.out.println(square);
        square = new Square(3);
        System.out.println(square);
        square = new Square(4,"yellow",false);
        System.out.println(square);

    }
}
