package movable_point;

public class Test {
    public static void main(String[] args) {
        Point point = new Point(1,3);
        System.out.println(point);
        System.out.println("----------");
        MovablePoint movablePoint = new MovablePoint(1,2);
        System.out.println(movablePoint);
        movablePoint.move();
        System.out.println(movablePoint);
        movablePoint.move();
        System.out.println(movablePoint);
    }
}
