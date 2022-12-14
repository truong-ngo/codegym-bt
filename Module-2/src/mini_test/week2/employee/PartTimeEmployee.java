package mini_test.week2.employee;

import java.io.Serializable;

public class PartTimeEmployee extends Employee implements Serializable {
    private int workHour;
    private final int HOURLY_WAGES = 100000;

    public PartTimeEmployee() {

    }

    public PartTimeEmployee(String id, String name, int age, String phoneNumber, String email, int workHour) {
        super(id, name, age, phoneNumber, email);
        this.workHour = workHour;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public int getHOURLY_WAGES() {
        return HOURLY_WAGES;
    }

    @Override
    public int getActualSalary() {
        return workHour * HOURLY_WAGES;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary = " + getActualSalary();
    }
    @Override
    public int compareTo(Employee employee) {
        return Integer.compare(getActualSalary(), employee.getActualSalary());
    }
}
