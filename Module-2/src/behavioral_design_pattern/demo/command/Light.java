package behavioral_design_pattern.demo.command;

public class Light {
    private boolean on;
    public void switchOn() {
        on = true;
        System.out.println("On");
    }

    public void switchOff() {
        on = false;
        System.out.println("Off");
    }
}
