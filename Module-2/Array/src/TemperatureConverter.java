import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        double celsius, fahrenheit;
        int choice = -1;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Menu:");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Fahrenheit: ");
                    fahrenheit = input.nextDouble();
                    celsius = fahrenheitToCelsius(fahrenheit);
                    System.out.println("Celsius is: " + celsius);
                    break;
                case 2:
                    System.out.println("Enter Celsius: ");
                    celsius = input.nextDouble();
                    fahrenheit = fahrenheitToCelsius(celsius);
                    System.out.println("Fahrenheit is: " + fahrenheit);
                    break;
                case 0:
                    System.exit(0);
            }
        }
        while (choice != 0);
    }
    public static double toToFahrenheit(double celsius) {
        double fahrenheit = celsius * 9 / 5 + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }
}
