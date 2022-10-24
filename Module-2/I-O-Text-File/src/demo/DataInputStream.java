package demo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("I-O-Text-File/src/demo/data-input-stream.txt");
            java.io.DataInputStream dataInputStream = new java.io.DataInputStream(fileInputStream);
            System.out.println(dataInputStream.readInt());
        } catch (EOFException ignored) {
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
