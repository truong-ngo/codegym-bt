package structural_design_pattern.facade_deployment;

import java.util.ArrayList;
import java.util.List;

public class FilterOdd {
    public List<Integer> filterOdd(List<Integer> numbers) {
        List<Integer> newList = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                newList.add(number);
            }
        }
        return newList;
    }
}
