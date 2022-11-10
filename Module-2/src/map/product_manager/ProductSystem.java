package map.product_manager;

import java.util.Scanner;

public class ProductSystem {
    private ProductManager productManager;
    private Scanner scanner;

    public ProductSystem() {
        productManager = new ProductManager();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("MENU:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Product");
            System.out.println("5. Search Product by name");
            System.out.println("6. Sort Product by ascending price");
            System.out.println("7. Sort Product by descending price");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("ADD PRODUCT");
                    productManager.addProduct(scanner);
                    break;
                case 2:
                    System.out.println("UPDATE PRODUCT");
                    System.out.println("Enter id");
                    String updateId = scanner.nextLine();
                    productManager.updateProduct(updateId, scanner);
                    break;
                case 3:
                    System.out.println("DELETE PRODUCT");
                    System.out.println("Enter id");
                    String deleteId = scanner.nextLine();
                    productManager.deleteProduct(deleteId);
                    break;
                case 4:
                    System.out.println("DISPLAY PRODUCT");
                    productManager.display();
                    break;
                case 5:
                    System.out.println("SEARCH PRODUCT");
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    productManager.searchProductByName(name);
                    break;
                case 6:
                    System.out.println("SORT BY ASCENDING PRICE");
                    productManager.sortProductAscendingPrice();
                    break;
                case 7:
                    System.out.println("SORT BY DESCENDING PRICE");
                    productManager.sortProductDescendingPrice();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
