package behavioral_design_pattern.demo.strategy;

public class NoFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("???");
    }
}
