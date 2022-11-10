package map.product_manager;

public class Product implements Comparable<Product> {
    private String Id;
    private String name;
    private int price;
    private String category;

    public Product(String id, String name, int price, String category) {
        Id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product: " +
                "Id = " + Id +
                ", name = " + name +
                ", price = " + price +
                ", category = " + category;
    }

    @Override
    public int compareTo(Product o) {
        return price - o.getPrice();
    }
}
