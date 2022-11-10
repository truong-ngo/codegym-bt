package stack_queue.stack_array;

public class StackArrayTest {
    public static void main(String[] args) {
        StackArray array = new StackArray(5);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.display();
        array.push(6);
        array.pop();
        array.display();
        array.pop();
        array.display();
        array.pop();
        array.display();
        array.pop();
        array.display();
        array.pop();
        array.display();
        array.pop();
        array.display();
    }
}
