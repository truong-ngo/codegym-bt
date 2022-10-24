package binary_search;

public class BinarySearch {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public static int binarySearch(int[] list, int value) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (value < list[mid]) {
                high = mid - 1;
            } else if (value == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.binarySearch(list, 50));
        System.out.println(BinarySearch.binarySearch(list, 68));
    }
}
