package list.linked_list;

public class MyLinkedListsTest {
    public static void main(String[] args) {
        MyLinkedLists<String> str = new MyLinkedLists<String>();
        str.addLast("a");
        str.addLast("a");
        str.addLast("a");
        str.addLast("b");
        str.addLast("c");
        str.addLast("a");
        str.addLast("d");
        str.addLast("a");
        str.addLast("e");
        str.addLast("a");
        str.addLast("a");
        str.addLast("e");
        str.addLast("a");
        str.addLast("a");
        str.remove("a");
        str.printList();
    }
}
