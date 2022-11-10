package search_sort.selection_sort;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[i]) {
                    double temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        for (Double d : list) {
            System.out.print(d + "  ");
        }
    }
}
