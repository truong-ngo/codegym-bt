package behavioral_design_pattern.demo.command;

public class Client {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        remote.setCommand(lightOn);
        remote.pressButton();
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
