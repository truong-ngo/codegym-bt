public class Main {
    public static void main(String[] args) {
        // Student
        Student.change();
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Phong");

        s1.display();
        s2.display();
        s3.display();

        // Car
        Car car1 = new Car("Mazda 3", "Skyactiv 3");
        System.out.println(Car.getNumberOfCars());
        Car car2 = new Car("Mazda 6", "Skyactiv 6");
        System.out.println(Car.getNumberOfCars());

        // Circle
        Circle circle1 = new Circle();
        System.out.println("Circle1's color is '" + circle1.getColor() + "', radius is '" + circle1.getRadius() + "', area is '" + circle1.getArea() + "'");
        Circle circle2 = new Circle(2);
        System.out.println("Circle2's color is '" + circle2.getColor() + "', radius is '" + circle2.getRadius() + "', area is '" + circle2.getArea() + "'");

        // Students
        Students s4 = new Students();
        s4.setName("John");
        s4.setClasses("C0822I1");
        s4.getInfo();
    }
}