package behavioral_design_pattern.demo.template_method;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        Generalization algorithm = new Realization();
        algorithm.findSolution();
    }
}
