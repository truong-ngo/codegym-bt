package mini_test.week3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private final String NUMBER_REGEX = "\\d+";
    private final String CATEGORY_REGEX = "[1-3]";
    private Pattern pattern;
    private Matcher matcher;

    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public boolean isValidNumber(String number) {
        pattern = Pattern.compile(NUMBER_REGEX);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public boolean isValidCategory(String category) {
        pattern = Pattern.compile(CATEGORY_REGEX);
        matcher = pattern.matcher(category);
        return matcher.matches();
    }

    public long inputId() {
        while (true) {
            System.out.println("Enter id: ");
            String strId = scanner.nextLine();
            if (isValidNumber(strId)) {
                return Long.parseLong(strId);
            } else {
                System.out.println("Invalid price, please re-enter");
            }
        }
    }

    public String inputName() {
        System.out.println("Enter name: ");
        return scanner.nextLine();
    }

    public double inputPrice() {
        while (true) {
            System.out.println("Enter price: ");
            String strPrice = scanner.nextLine();
            if (isValidNumber(strPrice)) {
                return Double.parseDouble(strPrice);
            } else {
                System.out.println("Invalid price, please re-enter");
            }
        }
    }

    public int inputQuantity() {
        while (true) {
            System.out.println("Enter quantity: ");
            String strQuantity = scanner.nextLine();
            if (isValidNumber(strQuantity)) {
                return Integer.parseInt(strQuantity);
            } else {
                System.out.println("Invalid quantity, please re-enter");
            }
        }
    }

    public Category inputCategory() {
        int choice;
        while (true) {
            System.out.println("1. Mobile: ");
            System.out.println("2. Tablet: ");
            System.out.println("3. Laptop: ");
            System.out.println("Select category: ");
            String strChoice = scanner.nextLine();
            if (isValidCategory(strChoice)) {
                choice = Integer.parseInt(strChoice);
                break;
            } else {
                System.out.println("Invalid choice, please re-enter");
            }
        }
        Category category = null;
        switch (choice) {
            case 1:
                category = new Category("Mobile");
                break;
            case 2:
                category = new Category("Tablet");
                break;
            case 3:
                category = new Category("Laptop");
                break;
        }
        return category;
    }

    public Product inputProduct() {
        String name = inputName();
        double price = inputPrice();
        int quantity = inputQuantity();
        Category category = inputCategory();
        return new Product(name, price, quantity, category);
    }
}
