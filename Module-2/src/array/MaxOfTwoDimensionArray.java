package array;

import java.util.Scanner;

public class MaxOfTwoDimensionArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix row: ");
        int row = scanner.nextInt();
        System.out.println("Enter matrix column: ");
        int column= scanner.nextInt();
        int[][] array = new int[row][column];
        System.out.println("Array list: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * 100);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        int max = array[0][0];
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        System.out.println("Max value of Array is: " + max);
    }
}
