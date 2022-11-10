package stack_queue.reserve_stack_element;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeMap;

public class ReserveStack {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        int[] ints = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(ints));
        for (int anInt : ints) {
            integers.push(anInt);
        }
        for (int i = 0; i < ints.length; i++) {
            ints[i] = integers.pop();
        }
        System.out.println(Arrays.toString(ints));
        Stack<String> strings = new Stack<>();
        String[] str = {"a","b","c","d","e","f","g","h","i","j"};
        System.out.println(Arrays.toString(str));
        for (String string : str) {
            strings.push(string);
        }
        for (int i = 0; i < ints.length; i++) {
            str[i] = strings.pop();
        }
        System.out.println(Arrays.toString(str));

    }
}
