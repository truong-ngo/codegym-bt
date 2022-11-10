package search_sort.insertion_sort;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] list) {
        int value, pos;
        for (int i = 1; i < list.length; i++) {
            value = list[i];
            pos = i;
            while (pos > 0 && value < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = value;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for (int i : list) {
            System.out.print(i + "  ");
        }
    }
}
