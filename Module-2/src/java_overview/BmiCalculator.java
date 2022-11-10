package java_overview;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        System.out.print("Enter your weight (kilogram): ");
        weight = scanner.nextDouble();
        System.out.print("Enter your height (meter): ");
        height = scanner.nextDouble();
        bmi = weight / Math.pow(height,2);
        String result = "";
        if (bmi < 18.5) {
            result = "Underweight";
        } else if (bmi < 25) {
            result = "Normal";
        } else if (bmi < 30) {
            result = "Overweight";
        } else {
            result = "Obese";
        }
        System.out.println("Your BMI is: " + bmi + " (" + result +")");
    }
}