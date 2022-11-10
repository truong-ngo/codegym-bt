package array;

import java.util.Scanner;

public class DeleteElementFromArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println("Number array list: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
            System.out.print(array[i] + "\t");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\nEnter number X: ");
        int x = scanner.nextInt();
        int delIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                delIndex = i;
                array[i] = 0;
            }
        }
        if (delIndex != -1) {
            for (int i = delIndex; i < array.length - 1; i++) {
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
            System.out.println("New Array list: ");
            for (int j : array) {
                System.out.print(j + "\t");
            }
        } else {
            System.out.println(x + " is not an element of array");
        }
    }
}
