package string_regex.demo;

import java.util.Scanner;

public class DemoZz {
    public static void main(String[] args) {
        String str = "This is\na picture\nof me";
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        System.out.println(content);
    }
}
