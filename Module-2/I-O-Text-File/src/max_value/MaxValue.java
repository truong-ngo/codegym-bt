package max_value;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaxValue {
    public static List<Integer> readFile(String path) throws Exception {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException exception) {
            System.err.println("File not found");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return numbers;
    }

    public static void writeMax(String path, int max) throws IOException {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Max value is: " + max);
            bufferedWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int anInt : numbers) {
            if (max < anInt) {
                max = anInt;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        List<Integer> integers = readFile("I-O-Text-File/src/max_value/input.txt");
        int max = findMax(integers);
        writeMax("I-O-Text-File/src/max_value/output.txt", max);
    }
}

