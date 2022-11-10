package behavioral_design_pattern.strategy_implement;

import java.util.ArrayList;
import java.util.List;

public class SortList {
    private SortStrategy sortStrategy;
    private List<String> items = new ArrayList<>();

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void add(String name) {
        items.add(name);
    }

    public void sort() {
        sortStrategy.sort(items);
    }
}
