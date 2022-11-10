package io_text_file.sum_of_numbers;

import java.io.*;

public class SumOfNumbers {
    public static void main(String[] args) {
        readFileText("src/io_text_file/sum_of_numbers/numbers.txt");
    }
    public static void readFileText(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Sum is: " + sum);
        } catch (Exception exception) {
            System.out.println("File not found");
        }
    }
}
