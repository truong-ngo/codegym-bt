package week2.material;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class MaterialManager {
    private ArrayList<Material> materials = new ArrayList<>();

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public Material inputCrispyFlour(Scanner scanner) {
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        LocalDate manufacturingDate = LocalDate.of(2017, 0, 21);
        System.out.println("Enter price: ");
        int cost = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter quantity: ");
        double quantity = Double.parseDouble(scanner.nextLine());
        Material crispyFlour = new CrispyFlour(id, name, manufacturingDate, cost, quantity);
        return crispyFlour;
    }

    public Material inputMeat(Scanner scanner) {
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        LocalDate manufacturingDate = LocalDate.of(2017, Month.APRIL, 21);
        System.out.println("Enter price: ");
        int cost = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter weight: ");
        double weight = Double.parseDouble(scanner.nextLine());
        Material meat = new Meat(id, name, manufacturingDate, cost, weight);
        return meat;
    }

    public void addProduct(Material material) {
        materials.add(material);
    }

    public boolean checkIndex(int index) {
        return !(index < 0 || index >= materials.size());
    }

    public void deleteProduct(int index) {
        if (checkIndex(index)) {
            materials.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void updateProduct(int index, Material material) {
        if (checkIndex(index)) {
            materials.set(index, material);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void displayProduct() {
        for (Material material : materials) {
            System.out.println(material);
        }
    }
}
