package linked_list;

public class MyLinkedListsTest {
    public static void main(String[] args) {
        MyLinkedLists<String> str = new MyLinkedLists<String>();
        str.addLast("a");
        str.addLast("b");
        str.addLast("c");
        str.addLast("d");
        str.addLast("e");
        //str.printList();
        MyLinkedLists<String> str1 = str.clone();
        str1.printList();
    }
}
