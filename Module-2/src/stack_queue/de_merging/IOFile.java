package stack_queue.de_merging;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile<E> {

    public List<Student> readFileCSV(String path)  {
        List<Student> students = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                String code = arr[0];
                String name = arr[1];
                int age = Integer.parseInt(arr[2]);
                boolean gender = arr[3].equals("male");
                String address = arr[4];
                double GPA = Double.parseDouble((arr[5]));
                Student student = new Student(code, name, age, gender, address, GPA);
                students.add(student);
                str = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public void writeFileCSV(List<Student> students, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : students) {
                bufferedWriter.write(student.displayCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeOne(Student student, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(student.displayCSV());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
