package demo_abstract_interface;

public class Dog extends Animals {
    public Dog() {

    }

    @Override
    public void speak() {
        System.out.println("Dog");
    }

    public void chaseCat() {
        System.out.println("Chase cat");
    }
}
