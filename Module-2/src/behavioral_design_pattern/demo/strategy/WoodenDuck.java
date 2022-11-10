package behavioral_design_pattern.demo.strategy;

public class WoodenDuck extends Duck {
    public WoodenDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("This is wooden duck");
    }
}
