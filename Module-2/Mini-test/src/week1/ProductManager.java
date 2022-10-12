package week1;

import java.util.Scanner;

public class ProductManager {
    private Product[] products = new Product[0];

    public ProductManager() {

    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Product inputProduct() {
        Scanner input = new Scanner(System.in);
        Product product = new Product();
        String name, description, str;
        int price;
        boolean checkInput = false;
        System.out.println("Enter product data: ");
        do {
            System.out.println("Enter product name: ");
            name = input.nextLine();
            if (name.equals("")) continue;
            System.out.println("Enter  price: ");
            str = input.nextLine();
            if (str.equals("")) continue;
            else price = Integer.parseInt(str);
            System.out.println("Enter product description: ");
            description = input.nextLine();
            if (description.equals("")) continue;
            checkInput = true;
            product = new Product(name,price,description);
        } while (!checkInput);
        return product;
    }

    public Product inputEditProduct(Product editProduct) {
        Scanner input = new Scanner(System.in);
        Product product = new Product();
        String name, description, str;
        int price;
        boolean checkInput = false;
        System.out.println("Edit product data: ");
        do {
            System.out.println("Edit name: " + editProduct.getName());
            name = input.nextLine();
            if (name.equals("")) continue;
            System.out.println("Edit price: " + editProduct.getPrice());
            str = input.nextLine();
            if (str.equals("")) continue;
            else price = Integer.parseInt(str);
            System.out.println("Edit description: " + editProduct.getDescription());
            description = input.nextLine();
            if (description.equals("")) continue;
            checkInput = true;
            product = new Product(name,price,description);
        } while (!checkInput);
        return product;
    }

    public void addProduct() {
        Product inputProduct = inputProduct();
        int index = products.length;
        Product[] newProducts = new Product[index + 1];
        System.arraycopy(products, 0, newProducts, 0, index);
        newProducts[index] = inputProduct;
        setProducts(newProducts);
    }

    public void updateProduct(int index, Product product) {
        Product updateProduct = inputEditProduct(product);
        products[index].setName(updateProduct.getName());
        products[index].setPrice(updateProduct.getPrice());
        products[index].setDescription(updateProduct.getDescription());
    }

    public void deleteProduct(int index) {
        Product[] newProductArray = new Product[products.length - 1];
        if (index >= 0) System.arraycopy(products, 0, newProductArray, 0, index);
        if (products.length - (index + 1) >= 0)
            System.arraycopy(products, index + 1, newProductArray, index + 1 - 1, products.length - (index + 1));
        setProducts(newProductArray);
    }

    public void displayProduct() {
        if (products.length == 0) {
            System.out.println("Products empty!!!");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void displayMaxPriceProduct() {
        int index = 0;
        int maxPrice = products[0].getPrice();
        for (int i = 1; i < products.length; i++) {
            if (products[i].getPrice() > maxPrice) {
                maxPrice = products[i].getPrice();
                index = i;
            }
        }
        System.out.println("Product has max price is: " + products[index].toString());
    }
}
