package mini_test.week2.material;

import java.util.Scanner;

public class TestMaterial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaterialManager materialManager = new MaterialManager();
        while (true) {
            System.out.println("MENU:");
            System.out.println("1. Add material");
            System.out.println("2. Update material");
            System.out.println("3. Delete material");
            System.out.println("4. Display material");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    boolean checkAdd = true;
                    while (checkAdd) {
                        System.out.println("ADD PRODUCT");
                        System.out.println("1. Add crispy flour");
                        System.out.println("2. Add meat");
                        System.out.println("0. Return");
                        System.out.println("Enter your choice");
                        int addChoice = Integer.parseInt(scanner.nextLine());
                        switch (addChoice) {
                            case 1:
                                Material crispyFlour = materialManager.inputCrispyFlour(scanner);
                                materialManager.addProduct(crispyFlour);
                                break;
                            case 2:
                                Material meat = materialManager.inputMeat(scanner);
                                materialManager.addProduct(meat);
                                break;
                            case 0:
                                checkAdd = false;
                        }
                    }
                    break;
                case 2:
                    boolean checkUpdate = true;
                    int updateIndex;
                    while (checkUpdate) {
                        System.out.println("UPDATE PRODUCT");
                        System.out.println("1. Update to crispy flour");
                        System.out.println("2. Update to meat");
                        System.out.println("0. Return");
                        System.out.println("Enter your choice");
                        int updateChoice = Integer.parseInt(scanner.nextLine());
                        switch (updateChoice) {
                            case 1:
                                System.out.println("Enter index: ");
                                updateIndex = Integer.parseInt(scanner.nextLine());
                                Material crispyFlour = materialManager.inputCrispyFlour(scanner);
                                materialManager.updateProduct(updateIndex, crispyFlour);
                                break;
                            case 2:
                                System.out.println("Enter index: ");
                                updateIndex = Integer.parseInt(scanner.nextLine());
                                Material meat = materialManager.inputMeat(scanner);
                                materialManager.updateProduct(updateIndex, meat);
                                break;
                            case 0:
                                checkUpdate = false;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter index: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    materialManager.deleteProduct(deleteIndex);
                    break;
                case 4:
                    materialManager.displayProduct();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Re-enter choice");
            }
        }
    }
}
