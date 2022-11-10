package search_sort.binary_search;

public class DemoLinearSearch {
    static int[] list = {2, 4, 7, 10, 11, 22, 35, 45, 50, 59, 60, 66, 69, 70, 79};

    public static int binarySearchDemo(int[] list, int value) {
        int left = 0;
        int right = list.length - 1;
        int mid = 0;
        int i = 1;
        while (right >= left) {
            System.out.println("Loop: " + i);
            System.out.println("Left pos = " + left);
            System.out.println("Right pos = " + right);
            i++;
            mid = (right + left) / 2;
            System.out.println("Mid pos = " + mid);
            System.out.println("Mid value = " + list[mid]);
            System.out.println("Search value = " + value);
            if (value < list[mid]) {
                right = mid - 1;
            } else if (value == list[mid]) {
                System.out.println("----------");
                System.out.println("After search");
                System.out.println("Left pos = " + left);
                System.out.println("Right pos = " + right);
                return mid;
            } else {
                left = mid + 1;
            }
            System.out.println("----------");
        }
        System.out.println("After search");
        if (value > list[mid]) {
            System.out.println("Left pos = " + (mid + 1));
            System.out.println("Right pos = " + right);
        } else if (value < list[mid]) {
            System.out.println("Left pos = " + left);
            System.out.println("Right pos = " + (mid - 1));
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("List:");
        for (int i : list) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("Index:");
        for (int i = 0; i < list.length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("----------");
        int result = binarySearchDemo(list, 33);
        System.out.println("Result = " + result);
    }
}
