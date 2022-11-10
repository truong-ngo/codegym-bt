package design_pattern.taxi;

public class ObjectPoolDemo {
    public static final int NUM_OF_CLIENT = 8;

    public static void main(String[] args) {
        TaxiPool taxiPool = new TaxiPool();
        for (int i = 0; i < NUM_OF_CLIENT; i++) {
            TaxiThread client = new TaxiThread(taxiPool);
            Thread thread = new Thread(client);
            thread.start();
        }
    }
}
