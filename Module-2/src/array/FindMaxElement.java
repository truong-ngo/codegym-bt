package array;

import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        int size;
        int[] property;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter size: ");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("Size does not exceed 20");
            }
        } while (size > 20);
        property = new int[size];
        System.out.println("Property list: ");
        for (int i = 0; i < size; i++) {
            property[i] = (int)(Math.random() * 100);
            System.out.print(property[i] + "\t");
        }
        int max = property[0];
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (property[i] > max) {
                max = property[i];
                index = i;
            }
        }
        System.out.printf("\nThe largest property value in the list is %d at position %d!",max,index);
    }
}
