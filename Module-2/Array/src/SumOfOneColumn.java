import java.util.Scanner;

public class SumOfOneColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array row: ");
        int row = scanner.nextInt();
        System.out.println("Enter array column: ");
        int column = scanner.nextInt();
        System.out.println("Enter column index: ");
        int index = scanner.nextInt();
        int[][] array = ReserveArray.generateTwoDimensionRandomArray(row,column,0,100);
        System.out.println("Two dimension array list:");
        ReserveArray.displayTwoDimensionArray(array);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][index];
        }
        System.out.println("Sum of columm '" + index + "' is: " + sum);
    }
}
