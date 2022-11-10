package behavioral_design_pattern.observer_implement;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
