package io_text_file.copy_file;

import java.io.*;
import java.util.Arrays;

public class CopyFile {
    public static byte[] readFile(String path) {
        byte[] data = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            int count = dataInputStream.available();
            data = new byte[count];
            int size = dataInputStream.read(data);
            dataInputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return data;
    }

    public static void writeData(byte[] data, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.write(data);
            dataOutputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void copyFile(byte[] data, String path) {
        writeData(data, path);
    }

    public static void main(String[] args) {
        String original = "src/io_text_file/copy_file/copy-file.txt";
        byte[] data = readFile(original);
        String path = "src/io_text_file/copy_file/new-file.txt";
        copyFile(data, path);
    }
}
