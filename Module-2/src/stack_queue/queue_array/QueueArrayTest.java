package stack_queue.queue_array;

public class QueueArrayTest {
    public static void main(String[] args) {
        QueueArray ints = new QueueArray(5);
        ints.enQueue(1);
        ints.enQueue(2);
        ints.enQueue(3);
        ints.enQueue(4);
        ints.enQueue(5);
        ints.display();
        ints.enQueue(6);
        ints.deQueue();
        ints.display();
        ints.deQueue();
        ints.display();
        ints.deQueue();
        ints.display();
        ints.deQueue();
        ints.display();
        ints.deQueue();
        ints.display();
        ints.deQueue();
    }
}
