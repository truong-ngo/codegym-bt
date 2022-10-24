package binary_search;

public class BinarySearchRecursion {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static int binarySearch(int[] list, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (right >= left) {
            if (value == list[mid]) {
                return mid;
            } else if (value > list[mid]) {
                return binarySearch(list, mid + 1,right,value);
            } else {
                return binarySearch(list, left, mid - 1, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.binarySearch(list, 45));
        System.out.println(BinarySearch.binarySearch(list, 50));
        System.out.println(BinarySearch.binarySearch(list, 69));
        System.out.println(BinarySearch.binarySearch(list, 52));
    }
}
