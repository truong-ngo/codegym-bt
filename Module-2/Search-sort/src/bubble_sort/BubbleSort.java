package bubble_sort;

import java.util.Arrays;

public class BubbleSort {
//        static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    static int[] list = {-2, 1, 2, 2, 3, 3, 5, 6, 12, 14};

    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        int count = 0;
        for (int i = 0; i < list.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = list.length - 1; j > i; j--) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    needNextPass = true;
                    count++;
                }
            }
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }
}
