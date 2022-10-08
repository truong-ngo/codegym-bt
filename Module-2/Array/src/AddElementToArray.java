import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        int[] newArray = new int[11];
        System.out.println("Array list: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
            System.out.print(array[i] + "\t");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter number X: ");
        int x = scanner.nextInt();
        System.out.println("Enter index: ");
        int index = scanner.nextInt();
        if (index <= -1 || index > array.length) {
            System.out.println("Cannot insert number X to array");
        } else {
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            newArray[index] = x;
            for (int i = index+1; i < newArray.length; i++) {
                newArray[i] = array[i-1];
            }
            System.out.println("New Array list: ");
            for (int i = 0; i < newArray.length; i++) {
                System.out.print(newArray[i] + "\t");
            }
        }
    }
}
