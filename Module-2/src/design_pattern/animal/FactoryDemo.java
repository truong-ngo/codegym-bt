package design_pattern.animal;

public class FactoryDemo {
    public static void main(String[] args) {
        FactoryAnimal factoryAnimal = new FactoryAnimal();
        Animal animal1 = factoryAnimal.getAnimal("feline");
        System.out.println("Animal 1 sound: " + animal1.makeSound());
        Animal animal2 = factoryAnimal.getAnimal("canine");
        System.out.println("Animal 2 sound: " + animal2.makeSound());
    }
}
