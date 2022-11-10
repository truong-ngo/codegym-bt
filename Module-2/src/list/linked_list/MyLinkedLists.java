package list.linked_list;

public class MyLinkedLists<E> {
    private Node head;
    private int numNodes;

    public MyLinkedLists() {

    }

    public MyLinkedLists(Node head) {
        this.head = head;
    }

    public void add(int index, E element) {
        checkIndex(index);
        if (index == 0) {
            addFirst(element);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            Node holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
        }
        numNodes++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Out of range");
        }
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        if (head == null) {
            addFirst(element);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(element);
            numNodes++;
        }
    }

    public E remove(int index) {
        checkIndex(index);
        if (index == 0) {
            E remove = (E) head.getData();
            removeFirst();
            return remove;
        }
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        E remove = (E) temp.next.getData();
        temp.next = temp.next.next;
        numNodes--;
        return remove;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        numNodes--;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        numNodes--;
    }

    public boolean remove(Object e) {
        boolean checkRemove = false;
        while (head.getData().equals(e)) {
            removeFirst();
            checkRemove = true;
        }
        for (int i = 1; i < numNodes; i++) {
            if (get(i).equals(e)) {
                remove(i);
                i--;
            }
        }
        return checkRemove;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(o)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(o)) {
                return i;
            } else {
                temp = temp.next;
            }
        }
        return -1;
    }
    public E get(int index) {
        checkIndex(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        E element = (E) temp.getData();
        return element;
    }

    public E getFirst() {
        return (E) head.getData();
    }

    public E getLast() {
        return get(numNodes - 1);
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public MyLinkedLists<E> clone() {
        MyLinkedLists<E> newList = new MyLinkedLists<E>();
        for (int i = 0; i < numNodes; i++) {
            newList.addLast(get(i));
        }
        return newList;
    }
    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
}
