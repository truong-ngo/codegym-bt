package behavioral_design_pattern.template_method_implement;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        Meal hamburgerMeal = new HamburgerMeal();
        hamburgerMeal.doMeal();
        System.out.println();
        Meal tacoMeal = new TacoMeal();
        tacoMeal.doMeal();
    }
}
