package week2.employee;

public class FullTimeEmployee extends Employee {
    private int bonus;
    private int fine;
    private int baseSalary;

    public FullTimeEmployee() {

    }

    public FullTimeEmployee(String id, String name, int age, String phoneNumber, String email, int bonus, int fine, int baseSalary) {
        super(id, name, age, phoneNumber, email);
        this.bonus = bonus;
        this.fine = fine;
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public int getActualSalary() {
        return baseSalary + bonus - fine;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary = " + getActualSalary();
    }

    @Override
    public int compareTo(Employee employee) {
        if (getActualSalary() < employee.getActualSalary()) return -1;
        else if (getActualSalary() > employee.getActualSalary()) return 1;
        else return 0;
    }
}
