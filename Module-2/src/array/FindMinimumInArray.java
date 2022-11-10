package array;

import java.util.Scanner;

public class FindMinimumInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Array list: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
            System.out.print(array[i] + "\t");
        }
        System.out.println("\nMinimum value of array is: " + FindMinimum.minValue(array));
    }
}
