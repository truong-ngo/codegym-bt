package stack_array;

public class StackArray {
    public int[] array;
    public int size;
    public int index = 0;

    public StackArray(int size) {
        this.size = size;
        array = new int[size];
    }

    public boolean isFull() {
        return (index == size);
    }

    public boolean isEmpty() {
        return (index == 0);
    }

    public int size() {
        return index;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack full, unable to push element");
        } else {
            array[index] = item;
            index++;
        }
    }

    public int pop() {
        int item = 0;
        if (isEmpty()) {
            System.out.println("Stack empty, unable to remove element");
        } else {
            index--;
            item = array[index];
            array[index] = 0;
        }
        return item;
    }

    public void display() {
        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
}
