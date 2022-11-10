package mini_test.week3;

public class Main {
    public static void main(String[] args) {
        String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.printf("+-----------------+------+%n");
        System.out.printf("| Column name     | ID   |%n");
        System.out.printf("+-----------------+------+%n");
        for (int i = 0; i < 5; i++) {
            System.out.printf(leftAlignFormat, "some data" + i, i * i);
        }
        System.out.printf("+-----------------+------+%n");
    }
}
