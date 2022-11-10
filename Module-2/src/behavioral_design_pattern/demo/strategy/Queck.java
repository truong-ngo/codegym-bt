package behavioral_design_pattern.demo.strategy;

public class Queck implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Queck queck...");
    }
}
