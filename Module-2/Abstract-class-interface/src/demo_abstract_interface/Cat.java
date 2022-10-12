package demo_abstract_interface;

public class Cat extends Animals {
    public Cat() {

    }

    @Override
    public void speak() {
        System.out.println("Cat");
    }

    public void run() {
        System.out.println("Run");
    }
}
