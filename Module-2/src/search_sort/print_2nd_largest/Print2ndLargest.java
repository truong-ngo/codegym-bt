package search_sort.print_2nd_largest;

public class Print2ndLargest {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,3,5,6,0,1,2,8,10};
        int[] arr1 = {1,1,1,1,1,1,1,1,1};
        find2ndLargest(arr);
        find2ndLargest(arr1);
    }

    public static void find2ndLargest(int[] array) {
        int max, secondMax;
        if (array.length < 2) {
            System.out.println("Doesn't exist 2nd largest value");
            return;
        }
        max = secondMax = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j < max && j > secondMax) {
                secondMax = j;
            }
        }
        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("Doesn't exist 2nd largest value");
        } else {
            System.out.println("2nd largest value is " + secondMax);
        }
    }
}
