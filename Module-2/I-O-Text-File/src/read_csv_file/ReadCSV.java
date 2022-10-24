package read_csv_file;

import java.io.*;
import java.util.Arrays;

public class ReadCSV {
    public static void main(String[] args) {
        readFile("I-O-Text-File/src/read_csv_file/csv-file.csv");
    }

    public static void readFile(String path) {
        String line;
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                System.out.println(Arrays.toString(strings));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
