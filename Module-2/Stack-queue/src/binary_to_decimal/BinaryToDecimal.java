package binary_to_decimal;

import java.util.Stack;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        int number = 999;
        int div;
        int mod = 0;
        do {
            div = number / 2;
            mod = number % 2;
            integers.push(mod);
            number = div;
        } while (div > 0);
        int size = integers.size();
        for (int i = 0; i < size; i++) {
            System.out.print(integers.pop());
        }
    }
}
