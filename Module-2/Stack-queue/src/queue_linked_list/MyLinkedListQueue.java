package queue_linked_list;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key) {
        Node temp = new Node(key);
        if (tail == null) {
            head = tail = temp;
        }
        tail.next = temp;
        tail = temp;
    }

    public Node dequeue() {
        if (head == null) {
            tail = null;
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    public void display() {
        System.out.print("Queue: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
