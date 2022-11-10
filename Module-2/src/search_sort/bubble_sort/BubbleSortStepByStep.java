package search_sort.bubble_sort;

public class BubbleSortStepByStep {
    static int[] list = {1, 2, 3, 5, 6, 8, 10, 13, 14, 12};
    public static void bubbleSortStepByStep(int[] list) {
        boolean needNextPass = true;
        for (int i = 0; i < list.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = list.length - 1; j > i; j--) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    needNextPass = true;
                }
            }
            if (!needNextPass) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            System.out.print("List after the " + i + " sort: ");
            for (int k : list) {
                System.out.print(k + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("\nBegin sort processing...");
        bubbleSortStepByStep(list);
    }
}
