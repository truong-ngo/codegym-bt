package demo;

import java.io.*;
import java.io.File;

public class PrintWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("I-O-Text-File/src/demo/print-writer.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        output.print("John T Smith " + 90 + "\n");
        output.print("Eric K Jones " + 85 + "\n");
        output.close();
    }
}
