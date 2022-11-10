package binary_file_serialization.product_binary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductSystem {
    private ProductManager productManager;

    public ProductSystem() {
        productManager = new ProductManager();
    }

    public void menu(Scanner scanner) {
        int choice = -1;
        boolean checkInput;
        do {
            do {
                try {
                    System.out.println("MENU: ");
                    System.out.println("1. Add product");
                    System.out.println("2. Delete product");
                    System.out.println("3. Display product");
                    System.out.println("4. Search product");
                    System.out.println("0. Exit");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    checkInput = true;
                } catch (InputMismatchException | NumberFormatException exception) {
                    System.out.println("Input is not a number");
                    checkInput = false;
                }
            } while (!checkInput);
            switch (choice) {
                case 1:
                    System.out.println("ADD PRODUCT: ");
                    productManager.addProduct(scanner);
                    break;
                case 2:
                    System.out.println("DELETE PRODUCT: ");
                    System.out.println("Enter index: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    productManager.deleteProduct(id);
                    break;
                case 3:
                    System.out.println("DISPLAY PRODUCT: ");
                    productManager.displayProductFromFile("src/binary_file_serialization/product_binary/product.txt");
                    break;
                case 4:
                    System.out.println("SEARCH PRODUCT: ");
                    System.out.println("Enter search value");
                    String value = scanner.nextLine();
                    productManager.searchProductsByName(value, "src/binary_file_serialization/product_binary/search.txt");
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);
    }
}
