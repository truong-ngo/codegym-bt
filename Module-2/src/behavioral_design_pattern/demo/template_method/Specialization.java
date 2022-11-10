package behavioral_design_pattern.demo.template_method;

public abstract class Specialization extends Generalization {
    @Override
    public void stepThree() {
        stepThree_1();
        stepThree_2();
        stepThree_3();
    }

    private void stepThree_1() {
        System.out.println("Specialization.stepThree_1");
    }

    public abstract void stepThree_2();

    private void stepThree_3() {
        System.out.println("Specialization.stepThree_3");
    }
}
