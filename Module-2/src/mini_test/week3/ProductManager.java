package mini_test.week3;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;
    public Input input;
    private String path = "";

    public ProductManager() {
        products = readFromFile();
        input = new Input();
    }

    public void add() {
        Product product = input.inputProduct();
        if (products.size() < 1) {
            product.setId(1);
        } else {
            long id = products.get(products.size() - 1).getId() + 1;
            product.setId(id);
        }
        products.add(product);
        writeToFile();
    }

    public void update() {
        long id;
        do {
            id = input.inputId();
        } while (!checkId(id));
        String name = input.inputName();
        double price = input.inputPrice();
        int quantity = input.inputQuantity();
        Category category = input.inputCategory();
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                product.setQuantity(quantity);
                product.setCategory(category);
            }
        }
    }

    public void delete(long id) {
        Product product;
        if (!checkId(id)) {
            System.out.println("No id match");
            return;
        } else {
            product = getProductById(id);
        }
        products.remove(product);
    }

    public void display(long id) {

    }

    public void display(Category category) {

    }

    public void displayAll(ArrayList<Product> products) {

    }

    public double totalPrice() {
        return 0;
    }

    public void displayByPriceMoreThan100000() {

    }

    public void displayByPriceAndCategory() {

    }

    public Product getProductById(long id) {
        Product product = null;
        if (!checkId(id)) {
            System.out.println("No id match");
        } else {
            for (Product item : products) {
                if (item.getId() == id) {
                    product = item;
                }
            }
        }
        return product;
    }

    public boolean checkId(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        System.out.println("No id match");
        return false;
    }

    public ArrayList<Product> readFromFile() {
        return new ArrayList<>();
    }

    public void writeToFile() {

    }
}
