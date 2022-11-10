package structural_design_pattern.facade_deployment;

import java.util.ArrayList;
import java.util.List;

public class RandomList {
    public List<Integer> generateList(int size, int min, int max) {
        List<Integer> integers = new ArrayList<>();
        RandomNumber number = new RandomNumber();
        for (int i = 0; i < size; i++) {
            int integer = number.generateRandomInteger(min, max);
            integers.add(integer);
        }
        return integers;
    }
}
