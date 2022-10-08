import java.util.Scanner;

public class ReserveArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int array[];
        do {
            System.out.println("Enter size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Size does not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        System.out.println("Array:");
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * 100);
            System.out.print(array[i] + "\t");
        }
        for (int i = 0; i < size/2; i++) {
            int temp = array[i];
            array[i] = array[size - 1 -i];
            array[size - 1 - i] = temp;
        }
        System.out.printf("\n%s\n","Reserve Array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
    }
    public static int[] generateRandomArray(int size, int start, int end) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(start + Math.random() * (end-start));
        }
        return array;
    }
    public static int[][] generateTwoDimensionRandomArray(int row, int column, int start, int end) {
        int[][] array = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(start + Math.random() * (end-start));
            }
        }
        return array;
    }
    public static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
    public static void displayTwoDimensionArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
