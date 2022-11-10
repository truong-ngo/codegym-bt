package string_regex.validate_class_name;

public class ClassNameExampleTest {
    public static final String[] validClassName = new String[] {"C0318H", "P0418I", "A1318L"};
    public static final String[] invalidClassName = new String[] {"M0318G", "P0323A", "C0822I1"};

    public static void main(String[] args) {
        ClassNameExample classNameExample = new ClassNameExample();
        for (String className : validClassName) {
            boolean isValid = classNameExample.validateClassName(className);
            System.out.println("Class name is " + className + " is valid " + isValid);
        }
        for (String className : invalidClassName) {
            boolean isValid = classNameExample.validateClassName(className);
            System.out.println("Class name is " + className + " is valid " + isValid);
        }
    }
}
