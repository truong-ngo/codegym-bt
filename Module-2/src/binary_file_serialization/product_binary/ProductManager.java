package binary_file_serialization.product_binary;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductManager implements Serializable {
    private static final long serialVersionUID = -266706354210367639L;
    private String path = "src/binary_file_serialization/product_binary/product.txt";

    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void readDataFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Product> productArrayList = (ArrayList<Product>) objectInputStream.readObject();
            products = productArrayList;
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("File empty or file not found");
        }
    }

    public void writeDataToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void addProduct(Scanner scanner) {
        readDataFromFile();
        boolean checkFlag;
        String name = null, brand = null, description = null;
        int id = 0, price = 0;
        do {
            try {
                System.out.println("Enter id: ");
                id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name: ");
                name = scanner.nextLine();
                System.out.println("Enter brand: ");
                brand = scanner.nextLine();
                System.out.println("Enter price: ");
                price = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter description: ");
                description = scanner.nextLine();
                checkFlag = true;
            } catch (InputMismatchException | NumberFormatException exception) {
                System.err.println("Input is not a number");
                checkFlag = false;
            }
        } while (!checkFlag);
        Product product = new Product(id, name, brand, price, description);
        products.add(product);
        writeDataToFile();
    }

    public Product deleteProduct(int index) {
        readDataFromFile();
        if (products.size() == 0) {
            return null;
        } else {
            Product product = products.get(index);
            products.remove(index);
            writeDataToFile();
            return product;
        }
    }

    public void displayProductFromFile(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<Product> lists = (ArrayList<Product>) object;
            for (Product product : lists) {
                System.out.println(product);
            }
            objectInputStream.close();
        } catch (IOException exception) {
            System.out.println("File empty or file not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Wrong file");
        }
    }

    public void searchProductsByName(String value, String path) {
        readDataFromFile();
        boolean check = false;
        ArrayList<Product> searchProducts = new ArrayList<>();
        String searchValue = value.toLowerCase();
        for (Product product : products) {
            String name = product.getName().toLowerCase();
            if (name.contains(searchValue)) {
                searchProducts.add(product);
                check = true;
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(path);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(searchProducts);
                    objectOutputStream.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                displayProductFromFile(path);
            }
        }
        if (!check) {
            System.out.println("Value not found");
        }
    }
}
