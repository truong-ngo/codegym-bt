package clean_code.extract_method;

public class Test {
    public static void main(String[] args) {
        double radius = 10;
        double height = 20;
        double volume = Cylinder.getVolume(radius, height);
        System.out.println(volume);
    }
}
