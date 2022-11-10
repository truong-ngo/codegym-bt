package binary_file_serialization.demo;

import java.io.FileInputStream;

public class ObjectInputStream {
    public static void main(String[] args) {
        java.io.ObjectInputStream objectInputStream;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/binary_file_serialization/demo/product.txt");
            objectInputStream = new java.io.ObjectInputStream(fileInputStream);
            Product product;
            while ((product = (Product) objectInputStream.readObject()) != null) {
                System.out.println(product);
            }
        } catch (Exception exception) {
            System.out.println();
        }
    }
}
