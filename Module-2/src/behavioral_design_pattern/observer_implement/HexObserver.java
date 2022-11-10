package behavioral_design_pattern.observer_implement;

public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        subject.add(this);
    }

    @Override
    public void update() {
        System.out.print(Integer.toHexString(subject.getState()) + "\t");
    }
}
