package demo_abstract_interface;

public class Demo {
    public static void main(String[] args) {
        AnimalsList animalsList = new AnimalsList();
        Animals dog = new Dog();
        Animals cat = new Cat();
        animalsList.add(dog);
        animalsList.add(cat);
    }
}
