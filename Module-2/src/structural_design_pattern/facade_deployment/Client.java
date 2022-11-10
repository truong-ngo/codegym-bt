package structural_design_pattern.facade_deployment;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        RandomListFacade randomList = new RandomListFacade();
        List<Integer> list = randomList.generateList(20,0,20);
        List<Integer> oddList = randomList.filterOdd(list);
        List<Integer> evenList = randomList.filterEven(list);
        System.out.println("List");
        randomList.printList(list);
        System.out.println("Filter Odd");
        randomList.printList(oddList);
        System.out.println("Filter Even");
        randomList.printList(evenList);
    }
}
