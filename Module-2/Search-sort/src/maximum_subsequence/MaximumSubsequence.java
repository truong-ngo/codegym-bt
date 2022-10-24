package maximum_subsequence;

import java.util.LinkedList;
import java.util.Scanner;

public class MaximumSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string");
        String str = scanner.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {                    // 0(n)
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {            // 0(n - 1)
                if (str.charAt(j) > list.getLast()) {               // C1
                    list.add(str.charAt(j));
                }
            }
            if (list.size() > max.size()) {                         // n
                max.clear();
                max.addAll(list);
            }
            list.clear();                                           // C3
        }
        for (Character c : max) {                                   // n
            System.out.print(c);                                    // O(n^2)
        }
    }
}
