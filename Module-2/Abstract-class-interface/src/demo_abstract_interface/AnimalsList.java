package demo_abstract_interface;

public class AnimalsList {
    private Animals[] animals = new Animals[5];
    private int index = 0;

    public AnimalsList() {

    }

    public void add(Animals animal) {
        if (index < animals.length) {
            animals[index] = animal;
            System.out.println("Animal add adt index: " + index);
            index++;
        }
    }

    public Animals get(int index) {
        return this.animals[index];
    }

}
