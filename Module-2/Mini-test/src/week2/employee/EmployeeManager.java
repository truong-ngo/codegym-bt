package week2.employee;

import week2.material.CrispyFlour;
import week2.material.Material;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public Employee inputEmployee(Scanner scanner, String employeeType) {
        Employee employee = null;
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter phone email: ");
        String email = scanner.nextLine();
        switch (employeeType) {
            case "Part-Time":
                System.out.println("Enter work hour: ");
                int workHour = Integer.parseInt(scanner.nextLine());
                employee = new PartTimeEmployee(id, name, age, phoneNumber, email, workHour);
                break;
            case "Full-Time":
                System.out.println("Enter bonus");
                int bonus = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter fine");
                int fine = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter base salary");
                int baseSalary = Integer.parseInt(scanner.nextLine());
                employee = new FullTimeEmployee(id, name, age, phoneNumber, email, bonus, fine, baseSalary);
                break;
        }
        return employee;
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean checkIndex(int index) {
        return !(index < 0 || index >= employees.size());
    }

    public void deleteEmployee(int index) {
        if (checkIndex(index)) {
            employees.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void updateEmployee(int index, Employee employee) {
        if (checkIndex(index)) {
            employees.set(index, employee);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void displayEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public int getAverageSalary() {
        int totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getActualSalary();
        }
        return totalSalary / employees.size();
    }

    public void displayFullTimeEmployeeHasSalaryBelowAverage() {
        for (Employee employee : employees) {
            if (employee instanceof FullTimeEmployee) {
                if (employee.getActualSalary() < getAverageSalary()) {
                    System.out.println(employee);
                }
            }
        }
    }

    public int getTotalSalaryOfPartTimeEmployee() {
        int totalSalaryOfPartTimeEmployee = 0;
        for (Employee employee : employees) {
            if (employee instanceof PartTimeEmployee) {
                totalSalaryOfPartTimeEmployee += employee.getActualSalary();
            }
        }
        return totalSalaryOfPartTimeEmployee;
    }

    public void sortFullTimeEmployeeSalary() {
        Collections.sort(employees);
        for (Employee employee : employees) {
            if (employee instanceof FullTimeEmployee) {
                System.out.println(employee);
            }
        }
    }
}
