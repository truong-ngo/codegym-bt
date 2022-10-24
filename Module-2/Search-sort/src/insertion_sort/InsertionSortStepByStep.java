package insertion_sort;

public class InsertionSortStepByStep {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] list) {
        int key, pos;
        for (int i = 1; i < list.length; i++) {
            key = list[i];
            pos = i;
            while (pos > 0 && key < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = key;
            System.out.println("List after " + i + " time sort");
            for (int anInt : list) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Before Sort");
        for (int i : list) {
            System.out.print(i + "  ");
        }
        System.out.println();
        insertionSort(list);
        System.out.println("After Sort");
        for (int i : list) {
            System.out.print(i + "  ");
        }
    }
}
