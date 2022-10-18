package week2.material;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    private double quantity;

    public CrispyFlour() {

    }

    public CrispyFlour(double quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusYears(1);
    }

    @Override
    public double getRealMoney() {
        return getAmount() * DISCOUNT;
    }

    @Override
    public String toString() {
        return "CrispyFlour {" +
                "quantity=" + quantity +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                '}';
    }
}
