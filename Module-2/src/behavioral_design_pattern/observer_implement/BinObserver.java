package behavioral_design_pattern.observer_implement;

public class BinObserver extends Observer {
    public BinObserver(Subject subject) {
        this.subject = subject;
        subject.add(this);
    }

    @Override
    public void update() {
        System.out.print(Integer.toBinaryString(subject.getState()) + "\t");
    }
}
