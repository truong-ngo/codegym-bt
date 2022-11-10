package mini_test.week2.employee;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();
        Employee fullTime1 = new FullTimeEmployee("F1","Full Time 1",23,"123456","common",500,0,2200);
        Employee fullTime2 = new FullTimeEmployee("F2","Full Time 2",23,"123456","common",300,0,2500);
        Employee fullTime3 = new FullTimeEmployee("F3","Full Time 3",23,"123456","common",400,0,2100);
        Employee fullTime4 = new FullTimeEmployee("F4","Full Time 4",23,"123456","common",700,0,2800);
        Employee fullTime5 = new FullTimeEmployee("F5","Full Time 5",23,"123456","common",600,0,2400);
        Employee partTime1 = new PartTimeEmployee("P1","Part Time 1", 23, "234567", "qwerty", 130);
        Employee partTime2 = new PartTimeEmployee("P2","Part Time 2", 23, "234567", "qwerty", 120);
        Employee partTime3 = new PartTimeEmployee("P3","Part Time 3", 23, "234567", "qwerty", 110);
        Employee partTime4 = new PartTimeEmployee("P4","Part Time 4", 23, "234567", "qwerty", 125);
        Employee partTime5 = new PartTimeEmployee("P5","Part Time 5", 23, "234567", "qwerty", 115);
        employeeManager.addEmployee(fullTime1);
        employeeManager.addEmployee(fullTime2);
        employeeManager.addEmployee(fullTime3);
        employeeManager.addEmployee(fullTime4);
        employeeManager.addEmployee(fullTime5);
        employeeManager.addEmployee(partTime1);
        employeeManager.addEmployee(partTime2);
        employeeManager.addEmployee(partTime3);
        employeeManager.addEmployee(partTime4);
        employeeManager.addEmployee(partTime5);
        while (true) {
            System.out.println("MENU:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display Employee");
            System.out.println("5. Display Average Salary");
            System.out.println("6. Display Full Time Employee Have Salary Below Average");
            System.out.println("7. Display Total Salary of Part Time Employee");
            System.out.println("8. Sort by Price");
            System.out.println("9. Display Salary of Full Time Employee");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    boolean checkAdd = true;
                    Employee employee;
                    while (checkAdd) {
                        System.out.println("ADD EMPLOYEE");
                        System.out.println("1. Add part time employee");
                        System.out.println("2. Add full time employee");
                        System.out.println("0. Return");
                        System.out.println("Enter your choice");
                        int addChoice = Integer.parseInt(scanner.nextLine());
                        switch (addChoice) {
                            case 1:
                                employee = employeeManager.inputEmployee(scanner, "Part-Time");
                                employeeManager.addEmployee(employee);
                                break;
                            case 2:
                                employee = employeeManager.inputEmployee(scanner, "Full-Time");
                                employeeManager.addEmployee(employee);
                                break;
                            case 0:
                                checkAdd = false;
                        }
                    }
                    break;
                case 2:
                    boolean checkUpdate = true;
                    int updateIndex;
                    while (checkUpdate) {
                        System.out.println("UPDATE EMPLOYEE");
                        System.out.println("1. Update to part time employee");
                        System.out.println("2. Update to full time employee");
                        System.out.println("0. Return");
                        System.out.println("Enter your choice");
                        int updateChoice = Integer.parseInt(scanner.nextLine());
                        switch (updateChoice) {
                            case 1:
                                System.out.println("Enter index: ");
                                updateIndex = Integer.parseInt(scanner.nextLine());
                                employee = employeeManager.inputEmployee(scanner, "Part-Time");
                                employeeManager.updateEmployee(updateIndex, employee);
                                break;
                            case 2:
                                System.out.println("Enter index: ");
                                updateIndex = Integer.parseInt(scanner.nextLine());
                                employee = employeeManager.inputEmployee(scanner, "Full-Time");
                                employeeManager.updateEmployee(updateIndex, employee);
                                break;
                            case 0:
                                checkUpdate = false;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter index: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    employeeManager.deleteEmployee(deleteIndex);
                    break;
                case 4:
                    employeeManager.displayEmployee();
                    break;
                case 5:
                    System.out.println("Average salary is: " + employeeManager.getAverageSalary());
                    break;
                case 6:
                    employeeManager.displayFullTimeEmployeeHasSalaryBelowAverage();
                    break;
                case 7:
                    System.out.println("Total salary of Part time Employee: "
                                       + employeeManager.getTotalSalaryOfPartTimeEmployee());
                    break;
                case 8:
                    employeeManager.sortByPrice();
                    break;
                case 9:
                    employeeManager.sortFullTimeEmployeeSalary();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Re-enter choice");
            }
        }
    }
}
