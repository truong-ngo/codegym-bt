package binary_file_serialization.demo;

import java.io.FileOutputStream;

public class ObjectOutputStream {
    public static void main(String[] args) throws Exception {
        java.io.ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/binary_file_serialization/demo/product.txt",true);
            objectOutputStream = new java.io.ObjectOutputStream(fileOutputStream);
            Product product = new Product(1, "IPhone 12", 2800000, "New");
            Product product1 = new Product(2, "IPhone 13", 3000000, "New");
            Product product2 = new Product(3, "IPhone 14", 3200000, "New");
            objectOutputStream.writeObject(product);
            objectOutputStream.writeObject(product1);
            objectOutputStream.writeObject(product2);
            objectOutputStream.flush();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            objectOutputStream.close();
        }
        System.out.println("Success!");
    }
}
