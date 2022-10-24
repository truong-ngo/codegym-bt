package algorithm_complexity;

import java.util.Scanner;

public class AlgorithmComplexity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
        int[] frequentChar = new int[256];                      // O(1)
        for (int i = 0; i < inputString.length(); i++) {        // O(n)
            int ascii = (int) inputString.charAt(i);
            frequentChar[ascii] += 1;
        }
        int max = frequentChar[0];                              // O(1)
        char character = (char) 255;                            // O(1)
        for (int i = 1; i < 256; i++) {
            if (max < frequentChar[i]) {                        // O(256)
                max = frequentChar[i];
                character = (char) i;
            }
        }                                                       // O(255) || O(n)
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}
