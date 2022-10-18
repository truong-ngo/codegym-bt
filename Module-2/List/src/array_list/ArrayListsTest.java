package array_list;

public class ArrayListsTest {
    public static void main(String[] args) {
        ArrayLists<Integer> numbers = new ArrayLists<Integer>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(1,2);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
        int removeNumber = numbers.remove(4);
        System.out.println(removeNumber);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
        System.out.println(numbers.contains(2));
        System.out.println(numbers.indexOf(6));
        numbers.clear();
        System.out.println(numbers.size());
    }
}
