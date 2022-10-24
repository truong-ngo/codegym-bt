package demo;

import java.io.FileOutputStream;

public class ObjectOutputStream {
    public static void main(String[] args) throws Exception {
        java.io.ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Binary-file-serialization/src/demo/product.txt");
            objectOutputStream = new java.io.ObjectOutputStream(fileOutputStream);
            Product product = new Product(1, "IPhone 12", 2800000, "New");
            objectOutputStream.writeObject(product);
            objectOutputStream.flush();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            objectOutputStream.close();
        }
        System.out.println("Success!");
    }
}
