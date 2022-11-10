package stack_queue.queue_circle_link_list;

public class QueueCircle {
    public static void main(String[] args) {
        QueueCircleLinkList<Integer> integers = new QueueCircleLinkList<>();
        integers.enQueue(1);
        integers.enQueue(2);
        integers.enQueue(3);
        integers.enQueue(4);
        integers.enQueue(5);
        integers.enQueue(6);
        integers.displayQueue();
    }
}
