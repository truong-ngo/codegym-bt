package stack_queue.de_merging;

import java.util.List;

public class StudentManager {
    private String path = "src/stack_queue/de_merging/students.csv";
    private String malePath = "src/stack_queue/de_merging/male.csv";
    private String femalePath = "src/stack_queue/de_merging/female.csv";
    private List<Student> students;
    private IOFile<Student> ioFile;

    public StudentManager() {
        ioFile = new IOFile<>();
        students = ioFile.readFileCSV(path);
    }

    public QueueArray<Student> splitMale() {
        QueueArray<Student> male = new QueueArray<>(10);
        for (Student student : students) {
            if (student.isGender()) {
                male.enQueue(student);
            }
        }
        return male;
    }

    public QueueArray<Student> splitFemale() {
        QueueArray<Student> female = new QueueArray<>(10);
        for (Student student : students) {
            if (!student.isGender()) {
                female.enQueue(student);
            }
        }
        return female;
    }

    public void writeMale() {
        QueueArray<Student> male = splitMale();
        while (!male.isQueueEmpty()) {
            Student student = male.deQueue();
            ioFile.writeOne(student, malePath);
        }
    }

    public void writeFemale() {
        QueueArray<Student> female = splitFemale();
        while (!female.isQueueEmpty()) {
            Student student = female.deQueue();
            ioFile.writeOne(student, femalePath);
        }
    }
}
