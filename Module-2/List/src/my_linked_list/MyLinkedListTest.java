package my_linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("-----Test-----");
        MyLinkedList myLinkedList = new MyLinkedList(10);
        myLinkedList.addFirst(9);
        myLinkedList.addFirst(8);
        myLinkedList.addFirst(7);
        myLinkedList.addFirst(6);
        myLinkedList.PrintList();
        myLinkedList.add(4,5);
        myLinkedList.PrintList();
    }
}
