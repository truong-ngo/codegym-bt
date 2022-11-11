package stack_queue.de_merging;

public class QueueArray<E> {
    private int capacity;
    private E[] queueArr;
    public int head = 0;
    public int tail = -1;
    private int size = 0;

    public QueueArray(int size) {
        capacity = size;
        queueArr = (E[]) new Object[capacity];
    }

    public boolean isQueueFull() {
        return (size == capacity);
    }

    public boolean isQueueEmpty() {
        return (size == 0);
    }

    public void enQueue(E item) {
        if (isQueueFull()) {
            System.out.println("Overflow, unable to add element");
        } else {
            tail++;
            queueArr[tail] = item;
            size++;
        }
    }

    public E deQueue() {
        E item = null;
        if (isQueueEmpty()) {
            System.out.println("Queue empty, unable to remove element");
        } else {
            item = queueArr[0];
            for (int i = 1; i < size; i++) {
                queueArr[i - 1] = queueArr[i];
            }
            queueArr[tail] = null;
            size--;
            tail--;
        }
        return item;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(queueArr[i] + "  ");
        }
        System.out.println();
    }
}
