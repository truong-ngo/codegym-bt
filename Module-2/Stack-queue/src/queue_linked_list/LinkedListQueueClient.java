package queue_linked_list;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        System.out.println("Dequeued item is " + queue.dequeue().key);
        queue.display();
        Node dequeue2 = queue.dequeue();
        System.out.println("Dequeued item is " + dequeue2.key);
        queue.display();
    }
}
