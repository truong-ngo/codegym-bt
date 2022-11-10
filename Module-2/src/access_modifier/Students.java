package access_modifier;

public class Students {
    private String name;
    private String classes;

    Students() {};

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void getInfo() {
        System.out.println("Student name: " + this.name + ", classes: " + this.classes);
    }
}

