package array;

import java.util.Scanner;

public class CountCharacterOfString {
    public static void main(String[] args) {
        String str = "Hello World";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char letter = scanner.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (letter == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("String '" + str + "' have " + count + " character '" + letter + "'");
    }
}
