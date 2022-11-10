package list.my_list_class;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        System.out.println("Element 0: " + listInteger.get(0));
        System.out.println("Element 1: " + listInteger.get(1));
        System.out.println("Element 2: " + listInteger.get(2));
        System.out.println("Element 3: " + listInteger.get(3));
        System.out.println("Element 4: " + listInteger.get(4));
        //System.out.println(listInteger.get(6));
        System.out.println(listInteger.get(-1));
    }
}
