package behavioral_design_pattern.demo.strategy;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly fly...");
    }
}
