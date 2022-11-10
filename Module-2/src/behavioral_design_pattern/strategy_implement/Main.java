package behavioral_design_pattern.strategy_implement;

import javafx.collections.transformation.SortedList;

public class Main {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        sortList.add("Java");
        sortList.add("PHP");
        sortList.add("C#");
        sortList.add("Python");

        sortList.setSortStrategy(new QuickSort());
        sortList.sort();
        sortList.setSortStrategy(new SelectionSort());
        sortList.sort();
    }
}
