package thread.demo;

public class CustomerOperation {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Thread thread1 = new Thread() {
            public void run() {
                customer.withdraw(2000);
            }
        };
        thread1.start();
        Thread thread2 = new Thread() {
            public void run() {
                for (int i = 0; i < 4; i++) {
                    customer.deposit(300);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException exception) {
                        System.out.println(exception.getMessage());
                    }
                }
            }
        };
        thread2.start();
    }
}
