package io_text_file.copy_file;

import java.io.*;
import java.util.ArrayList;

public class CopFileText {
    public static void main(String[] args) {
        ArrayList<String> content = readFile("src/io_text_file/copy_file/copy-file.txt");
        String destination = "src/io_text_file/copy_file/new-file1.txt";
        writeFile(content, destination);
    }

    public static ArrayList<String> readFile(String path) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return strings;
    }

    public static void writeFile(ArrayList<String> content, String destination) {
        try {
            File file = new File(destination);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String str : content) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
