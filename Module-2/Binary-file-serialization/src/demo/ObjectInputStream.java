package demo;

import java.io.FileInputStream;

public class ObjectInputStream {
    public static void main(String[] args) {
        java.io.ObjectInputStream objectInputStream;
        try {
            FileInputStream fileInputStream = new FileInputStream("Binary-file-serialization/src/demo/product.txt");
            objectInputStream = new java.io.ObjectInputStream(fileInputStream);
            Product product = (Product) objectInputStream.readObject();
            System.out.println(product);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
