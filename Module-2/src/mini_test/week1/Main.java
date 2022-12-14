package mini_test.week1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        while (true) {
            System.out.println("Product Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Product");
            System.out.println("5. Display Max Price Product");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    System.out.println("Enter index: ");
                    int index = input.nextInt();
                    productManager.updateProduct(index, productManager.getProducts()[index]);
                    break;
                case 3:
                    System.out.println("Enter delete product's index: ");
                    int deleteIndex = input.nextInt();
                    productManager.deleteProduct(deleteIndex);
                    break;
                case 4:
                    productManager.displayProduct();
                    break;
                case 5:
                    productManager.displayMaxPriceProduct();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
