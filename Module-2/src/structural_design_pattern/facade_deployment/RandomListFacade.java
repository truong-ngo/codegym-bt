package structural_design_pattern.facade_deployment;

import java.util.List;

public class RandomListFacade {
    private RandomList randomList;
    private FilterEven filterEven;
    private FilterOdd filterOdd;
    private PrintList printList;

    public RandomListFacade() {
        randomList = new RandomList();
        filterEven = new FilterEven();
        filterOdd = new FilterOdd();
        printList = new PrintList();
    }

    public List<Integer> generateList(int size, int min, int max) {
        return randomList.generateList(size, min, max);
    }

    public List<Integer> filterEven(List<Integer> integers) {
        return filterEven.filterEven(integers);
    }

    public List<Integer> filterOdd(List<Integer> integers) {
        return filterOdd.filterOdd(integers);
    }

    public void printList(List<Integer> integers) {
        printList.printList(integers);
    }
 }
