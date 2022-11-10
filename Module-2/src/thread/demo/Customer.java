package thread.demo;

public class Customer {
    private int balance = 1000;

    public Customer() {
        System.out.println("Your account balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        System.out.println("Withdrawing: " + amount + "...");
        while (amount > balance) {
            System.out.println("Amount exceed!!!");
            try {
                wait();
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }
        balance -= amount;
        System.out.println("Withdraw successful, your balance is " + balance);
    }

    public synchronized void deposit(int amount) {
        System.out.println("Depositing " + amount + "...");
        balance += amount;
        System.out.println("Deposit successful, your balance is: " + balance);
        notify();
    }
}
