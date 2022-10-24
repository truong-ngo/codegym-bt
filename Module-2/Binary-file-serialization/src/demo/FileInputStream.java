package demo;

import java.io.IOException;
import java.io.InputStream;

public class FileInputStream {
    public static void main(String[] args) throws IOException {
        java.io.FileInputStream inputStream = new java.io.FileInputStream("Binary-file-serialization/src/demo/code-gym.txt");
        int i = -1;
        while ((i = inputStream.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();
        inputStream.close();

        java.io.FileInputStream fileInputStream = new java.io.FileInputStream("Binary-file-serialization/src/demo/hello-code-gym.txt");
        int count = fileInputStream.available();
        byte[] bytes = new byte[count];
        int j = -1;
        while ((j = fileInputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, j);
            System.out.print(s);
        }
        fileInputStream.close();
    }
}
