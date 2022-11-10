package mini_test.week2.employee;

import java.io.Serializable;

public abstract class Employee implements Comparable<Employee>, Serializable {
    private String id;
    private String name;
    private int age;
    private String phoneNumber;
    private String email;

    public Employee() {

    }

    public Employee(String id, String name, int age, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract int getActualSalary();

    @Override
    public String toString() {
        return "Employee: " +
               "Id = " + id + ", " +
               "Name = " + name + ", " +
               "Age = "  + age + ", " +
               "Phone Number = " + phoneNumber + ", " +
               "Email = " + email;
    }

    public abstract int compareTo(Employee employee);
}
