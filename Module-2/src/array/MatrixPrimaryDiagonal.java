package array;

import java.util.Scanner;

public class MatrixPrimaryDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix size: ");
        int size = scanner.nextInt();
        int[][] matrix = ReserveArray.generateTwoDimensionRandomArray(size,size,0,100);
        System.out.println("Matrix:");
        ReserveArray.displayTwoDimensionArray(matrix);
        int sumPrimaryDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            sumPrimaryDiagonal += matrix[i][i];
        }
        System.out.println("Sum of matrix primary diagonal: " + sumPrimaryDiagonal);
    }
}
