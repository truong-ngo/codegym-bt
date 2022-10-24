package array_out_of_bound_exception;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Array element: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayIndexOutOfBoundsException arrExample = new ArrayIndexOutOfBoundsException();
        Integer[] arr = arrExample.createRandom();

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nEnter index of any element: ");
            int index = scanner.nextInt();
            System.out.println("Value of element of " + index + " is " + arr[index]);
        } catch (IndexOutOfBoundsException exception) {
            System.err.println("Index exceeds the limit of the array");
        } catch (InputMismatchException exception) {
            System.err.println("Input is not a number");
        } finally {
            System.out.println("Continue execution");
        }
    }
}
