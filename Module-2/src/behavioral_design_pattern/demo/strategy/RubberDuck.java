package behavioral_design_pattern.demo.strategy;

public class RubberDuck extends Duck {
    public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("This is rubber duck");
    }
}
