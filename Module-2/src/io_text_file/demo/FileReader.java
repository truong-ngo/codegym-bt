package io_text_file.demo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;

public class FileReader {
    public static void main(String[] args) throws IOException {
        java.io.FileReader fileReader = null;
        int ch;
        try {
            fileReader = new java.io.FileReader("src/io_text_file/demo/file-reader.txt");
        } catch (IOException exception) {
            System.out.println("File not found");
        }
        while ((ch = fileReader.read()) != -1) {
            System.out.print((char) ch);
        }
        fileReader.close();
    }
}
