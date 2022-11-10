package behavioral_design_pattern.demo.observer;

public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observerOne = new Observer() {
            @Override
            public void update(String message) {
                System.out.println("Message 1 changed: " + message);
            }
        };
        subject.attach(observerOne);
        Observer observerTwo = new Observer() {
            @Override
            public void update(String message) {
                System.out.println("Message 2 changed: " + message);
            }
        };
        subject.attach(observerTwo);
        subject.notifyChange("Test change state 1");
        subject.detach(observerOne);
        subject.notifyChange("Test change state 2");
    }
}
