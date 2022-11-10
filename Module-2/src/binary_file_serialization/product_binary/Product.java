package binary_file_serialization.product_binary;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = -266706354210367639L;
    private int id;
    private String name;
    private String brand;
    private int price;
    private String description;

    public Product() {

    }

    public Product(int id, String name, String brand, int price, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product: " +
                "id = " + id +
                ", name = " + name +
                ", brand = " + brand +
                ", price = " + price +
                ", description = " + description;
    }
}
