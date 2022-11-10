package inheritance.circle_and_cylinder;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(2,"blue");
        System.out.println(circle);
        System.out.println("Circle area is: "
                            + circle.getArea()
                            + ", perimeter is: "
                            + circle.getPerimeter());

        Cylinder cylinder = new Cylinder(5,3,"red");
        System.out.println(cylinder);
        System.out.println("Cylinder bottom area is: "
                + cylinder.getArea()
                + ", volume is: "
                + cylinder.getVolume());
    }
}
