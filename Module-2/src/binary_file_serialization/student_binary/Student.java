package binary_file_serialization.student_binary;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -266706354210367639L;
    private int id;
    private String name;
    private String address;

    public Student() {

    }

    public Student(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.address = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student: " +
                "id = " + id +
                ", name = " + name +
                ", description = " + address;
    }
}
