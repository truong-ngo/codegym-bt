package behavioral_design_pattern.demo.template_method;

public abstract class Generalization {
    public void findSolution() {
        stepOne();
        stepTwo();
        stepThree();
        stepFour();
    }

    private void stepOne() {
        System.out.println("Generalization.stepOne");
    }

    public abstract void stepTwo();
    public abstract void stepThree();

    private void stepFour() {
        System.out.println("Generalization.stepFour");
    }
}
