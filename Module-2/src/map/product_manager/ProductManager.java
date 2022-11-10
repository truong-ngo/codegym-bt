package map.product_manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Scanner scanner) {
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter category: ");
        String category = scanner.nextLine();
        Product product = new Product(id, name, price, category);
        products.add(product);
    }

    public void updateProduct(String id, Scanner scanner) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                System.out.println("Edit name: " + products.get(i).getName());
                String name = scanner.nextLine();
                System.out.println("Edit price: " + products.get(i).getPrice());
                int price = Integer.parseInt(scanner.nextLine());
                System.out.println("Edit category: " + products.get(i).getCategory());
                String category = scanner.nextLine();
                Product product = new Product(id, name, price, category);
                products.set(i, product);
            } else {
                System.out.println("Id does not exist");
            }
        }
    }

    public void deleteProduct(String id) {
        int index = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;
            } else {
                System.out.println("Id does not exist");
            }
        }
        products.remove(index);
    }

    public void display() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void sortProductAscendingPrice() {
        Collections.sort(products);
    }

    public void sortProductDescendingPrice() {
        sortProductAscendingPrice();
        Collections.reverse(products);
    }

    public void searchProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
            }
        }
    }
}
