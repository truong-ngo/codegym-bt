package access_modifier;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public static void change() {
        college = "CODEGYM";
    }

    public void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
 }
