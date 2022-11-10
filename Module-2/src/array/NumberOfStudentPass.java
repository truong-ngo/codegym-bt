package array;

import java.util.Scanner;

public class NumberOfStudentPass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter a size: ");
            size = scanner.nextInt();
            if (size > 30) {
                System.out.println("Size should not exceed 30");
            }
        } while (size > 30);
        int[] marks = ReserveArray.generateRandomArray(size,3,11);
        System.out.println("Mark list: ");
        ReserveArray.displayArray(marks);
        int count = 0;
        for (int x : marks) {
            if (x >= 5) count++;
        }
        System.out.print("\nThe number of students passing the exam is " + count);
    }
}
