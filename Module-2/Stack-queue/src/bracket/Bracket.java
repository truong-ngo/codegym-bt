package bracket;

import java.util.*;

public class Bracket {
    public static void main(String[] args) {
        String str = "s * (s – a) * (s – b) * (s – c))";
        String[] strings = str.split("");
        Stack<String> stack = new Stack<>();
        System.out.println(checkBracket(strings,stack));
    }

    public static boolean checkBracket(String[] strings, Stack<String> stack) {
        for (String string : strings) {
            if (string.equals(")") && stack.isEmpty()) {
                return false;
            } else if (string.equals("(")) {
                stack.push(string);
            } else if (string.equals(")")) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
