package binary_file_serialization.product_binary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ProductSystem productSystem = new ProductSystem();
//        productSystem.menu(scanner);
        ProductManager productManager = new ProductManager();
        productManager.displayProductFromFile("src/binary_file_serialization/product_binary/product.txt");
    }
}
