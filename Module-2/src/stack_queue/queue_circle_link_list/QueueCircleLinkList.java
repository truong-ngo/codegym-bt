package stack_queue.queue_circle_link_list;

public class QueueCircleLinkList<E> {
    public Node<E> front;
    public Node<E> rear;

    public QueueCircleLinkList() {
        front = null;
        rear = null;
    }

    public void enQueue(E data) {
        Node<E> element = new Node<>(data);
        if (rear == null) {
            front = rear = element;
        } else {
            rear.link = element;
            rear = rear.link;
            rear.link = front;
        }
    }

    public E deQueue() {
        if (front == null) {
            return null;
        }
        E element = front.data;
        front = front.link;
        rear.link = front;
        return element;
    }

    public void displayQueue() {
        Node<E> temp = front;
        do {
            System.out.print(temp.data + "  ");
            temp = temp.link;
        }
        while (temp != front);
        System.out.println();
    }
}
