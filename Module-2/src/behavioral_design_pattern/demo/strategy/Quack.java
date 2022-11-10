package behavioral_design_pattern.demo.strategy;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack quack...");
    }
}
