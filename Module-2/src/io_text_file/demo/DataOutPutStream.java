package io_text_file.demo;

import java.io.*;
import java.io.DataInputStream;

public class DataOutPutStream {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/io_text_file/demo/data-output-stream.txt");
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);;
            dataOutputStream.writeInt(200);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
