package demo;

import java.io.File;
import java.io.IOException;

public class Scanner {
    public static void main(String[] args) throws IOException {
        File file = new File("I-O-Text-File/src/demo/scanner.txt");
        java.util.Scanner scanner = new java.util.Scanner(file);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
