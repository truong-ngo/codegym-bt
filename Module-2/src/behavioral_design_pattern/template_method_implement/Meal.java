package behavioral_design_pattern.template_method_implement;

public abstract class Meal {
    public void doMeal() {
        prepareIngredients();
        cook();
        eat();
        cleanUp();
    }

    public abstract void prepareIngredients();
    public abstract void cook();
    public void eat() {
        System.out.println("Delicious");
    }

    public abstract void cleanUp();
}
