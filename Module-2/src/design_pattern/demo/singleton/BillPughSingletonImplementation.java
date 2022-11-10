package design_pattern.demo.singleton;

public class BillPughSingletonImplementation {
    private BillPughSingletonImplementation() {

    }

    private static class SingletonHelper {
        private static final BillPughSingletonImplementation instance = new BillPughSingletonImplementation();
    }

    public static BillPughSingletonImplementation getInstance() {
        return SingletonHelper.instance;
    }
}
