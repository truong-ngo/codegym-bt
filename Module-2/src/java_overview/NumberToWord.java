package java_overview;

import java.util.Scanner;

public class NumberToWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = input.nextInt();
        String word = "";
        if (number <= 10) {
            switch (number) {
                case 0:
                    word = "Zero";
                    break;
                case 10:
                    word = "Ten";
                    break;
                default:
                    word = unitToWord(number);
            }
        } else if (number <= 100) {
            word = tenthOfUnitToWord(number);
        } else if (number < 1000) {
            word = unitToWord(number / 100) + " Hundred " + tenthOfUnitToWord(number % 100);
        }
        System.out.println(word);
    }
    public static String unitToWord(int number) {
        String word = "";
        switch (number) {
            case 1:
                word = "One";
                break;
            case 2:
                word = "Two";
                break;
            case 3:
                word = "Three";
                break;
            case 4:
                word = "Four";
                break;
            case 5:
                word = "Five";
                break;
            case 6:
                word = "Six";
                break;
            case 7:
                word = "Seven";
                break;
            case 8:
                word = "Eight";
                break;
            case 9:
                word = "Nine";
                break;
        }
        return word;
    }
    public static String tenthOfUnitToWord(int number) {
        String word = "";
        switch (number) {
            case 11:
                word = "Eleven";
                break;
            case 12:
                word = "Twelve";
                break;
            case 13:
                word = "Thirteen";
                break;
            case 14:
                word = "Fourteen";
                break;
            case 15:
                word = "Fifteen";
                break;
            case 16:
                word = "Sixteen";
                break;
            case 17:
                word = "Seventeen";
                break;
            case 18:
                word = "Eighteen";
                break;
            case 19:
                word = "Nineteen";
                break;
            case 20:
                word = "Twenty";
                break;
            default:
                String tenthOfUnit = "";
                switch (number / 10) {
                    case 2:
                        tenthOfUnit = "Twen";
                        break;
                    case 3:
                        tenthOfUnit = "Thir";
                        break;
                    case 5:
                        tenthOfUnit = "Fif";
                        break;
                    case 8:
                        tenthOfUnit = "Eigh";
                        break;
                    default:
                        tenthOfUnit = unitToWord(number / 10);
                }
                word = tenthOfUnit + "ty " + unitToWord(number % 10);
        }
        return word;
    }
}
