package behavioral_design_pattern.demo.strategy;

public class Main {
    public static void main(String[] args) {
        Duck woodenDuck = new WoodenDuck(new NoFly(), new MuteQuack());
        woodenDuck.fly();
        woodenDuck.quack();
        woodenDuck.swim();
        woodenDuck.display();
    }
}
