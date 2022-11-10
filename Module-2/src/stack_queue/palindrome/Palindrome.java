package stack_queue.palindrome;

import java.util.Arrays;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        boolean checkFlag = true;
        String str = "anna";
        str = str.toUpperCase();
        String[] strings = str.split("");
        Stack<String> stack = new Stack<>();
        for (String string : strings) {
            stack.push(string);
        }
        for (String string : strings) {
            if (!(string.equals(stack.pop()))) {
                checkFlag = false;
                break;
            }
        }
        if (checkFlag) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
    }
}
