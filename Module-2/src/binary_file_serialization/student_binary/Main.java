package binary_file_serialization.student_binary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile(students);
        readFile("src/binary_file_serialization/student_binary/student.txt");
    }
    public static void writeToFile(List<Student> students) {
        try {
            FileOutputStream file = new FileOutputStream("src/binary_file_serialization/student_binary/student.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(file);
            outputStream.writeObject(students);
            outputStream.close();
            file.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void readFile(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<Student> students = (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
