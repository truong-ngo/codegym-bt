package demo;

import java.io.IOException;

public class FileWriter {
    public static void main(String[] args) throws IOException {
        String str = "File Handling in Java using FileWriter and FileReader";
        java.io.FileWriter fileWriter = new java.io.FileWriter("I-O-Text-File/src/demo/file-writer.txt");
        for (int i = 0; i < str.length(); i++) {
            fileWriter.write(str.charAt(i));
        }
        System.out.println("Print successful");
        fileWriter.close();
    }
}
