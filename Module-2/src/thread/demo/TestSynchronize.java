package thread.demo;

public class TestSynchronize {
    public static void main(String[] args) {
        Table table = new Table();
        MyThread1 t1 = new MyThread1(table);
        MyThread2 t2 = new MyThread2(table);
        t1.start();
        t2.start();
    }
}
