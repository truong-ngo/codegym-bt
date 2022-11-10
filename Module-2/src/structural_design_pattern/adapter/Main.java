package structural_design_pattern.adapter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String myPath = "/Users/X1 Carbon/Desktop";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file or folder path: /Users/X1 Carbon/Desktop");
        String path = myPath;
        FileCalculator fileCalculator = new FileCalculatorAdapter();
        Client client = new Client(fileCalculator);
        client.printFileSize(path);
    }
}
