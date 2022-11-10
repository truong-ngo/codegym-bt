package abtract_class_interface.interface_comparator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(2);
        circles[1] = new Circle();
        circles[2] = new Circle(4, "grey", false);
        System.out.println("Pre-sort");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circles,circleComparator);
        System.out.println("After-sort");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
