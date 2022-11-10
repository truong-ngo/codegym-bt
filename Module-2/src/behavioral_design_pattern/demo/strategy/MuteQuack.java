package behavioral_design_pattern.demo.strategy;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("...");
    }
}
