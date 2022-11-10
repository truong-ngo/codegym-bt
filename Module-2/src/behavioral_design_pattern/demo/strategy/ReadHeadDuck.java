package behavioral_design_pattern.demo.strategy;

public class ReadHeadDuck extends Duck {
    public ReadHeadDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("This is red head duck");
    }
}
