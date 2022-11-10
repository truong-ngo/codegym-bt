package array;

public class ArrayConcat {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = new int[5];
        int[] concatArray = new int[15];
        System.out.println("Array 1 list: ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int)(Math.random() * 100);
            concatArray[i] = array1[i];
            System.out.print(array1[i] + "\t");
        }
        System.out.println("\nArray 2 list: ");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int)(Math.random() * 100);
            concatArray[i + array1.length] = array2[i];
            System.out.print(array2[i] + "\t");
        }
        System.out.println("\nConcat Array list: ");
        for (int i = 0; i < concatArray.length; i++) {
            System.out.print(concatArray[i] + "\t");
        }
    }
}
