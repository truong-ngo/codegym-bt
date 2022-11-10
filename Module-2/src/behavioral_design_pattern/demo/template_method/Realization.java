package behavioral_design_pattern.demo.template_method;

public class Realization extends Specialization {
    @Override
    public void stepTwo() {
        System.out.println("Realization.stepTwo");
    }

    @Override
    public void stepThree_2() {
        System.out.println("Realization.stepThree_2");
    }
}
