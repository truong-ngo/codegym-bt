package triangle_classifier;

public class TriangleClassifier {
    public static String triangleClassifier(int sideA, int sideB, int sideC) {
        if (!isTriangle(sideA, sideB, sideC)) {
            return "Is not a Triangle";
        }
        boolean isEquilateralTriangle = sideA == sideB && sideA == sideC;
        boolean isIsoscelesTriangle = sideA == sideB || sideA == sideC || sideB == sideC;
        if (isEquilateralTriangle) {
            return "Equilateral Triangle";
        } else if (isIsoscelesTriangle) {
            return "Isosceles Triangle";
        } else {
            return "Normal Triangle";
        }
    }

    public static boolean isTriangle(int sideA, int sideB, int sideC) {
        return sideA > 0 && sideB > 0 && sideC > 0 && sideB + sideC > sideA &&
               sideA + sideB > sideC && sideA + sideC > sideB;
    }
}
