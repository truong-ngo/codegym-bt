package structural_design_pattern.adapter_deployment;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int number = (int) (Math.random() * 100);
            integers.add(number);
        }
        System.out.println(integers);
        Client client = new Client(new CollectionOperationAdapter());
        client.printMaxValue(integers);
    }
}
