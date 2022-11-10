package automated_testing_tdd.triangle_classifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void triangleClassifierNotATriangle() {
        int sideA = 1;
        int sideB = 2;
        int sideC = 4;
        String expected = "Is not a Triangle";
        String result = TriangleClassifier.triangleClassifier(sideA, sideB, sideC);
        assertEquals(expected, result);
    }

    @Test
    void triangleClassifierEquilateralTriangle() {
        int sideA = 4;
        int sideB = 4;
        int sideC = 4;
        String expected = "Equilateral Triangle";
        String result = TriangleClassifier.triangleClassifier(sideA, sideB, sideC);
        assertEquals(expected, result);
    }

    @Test
    void triangleClassifierIsoscelesTriangle() {
        int sideA = 3;
        int sideB = 4;
        int sideC = 4;
        String expected = "Isosceles Triangle";
        String result = TriangleClassifier.triangleClassifier(sideA, sideB, sideC);
        assertEquals(expected, result);
    }

    @Test
    void triangleClassifierNormalTriangle() {
        int sideA = 4;
        int sideB = 5;
        int sideC = 6;
        String expected = "Normal Triangle";
        String result = TriangleClassifier.triangleClassifier(sideA, sideB, sideC);
        assertEquals(expected, result);
    }

    @Test
    void testIsTriangle() {
        int sideA = 4;
        int sideB = 5;
        int sideC = 6;
        boolean result = TriangleClassifier.isTriangle(sideA, sideB, sideC);
        assertTrue(result);
    }

    @Test
    void testIsNotTriangle() {
        int sideA = 1;
        int sideB = 2;
        int sideC = 3;
        boolean result = TriangleClassifier.isTriangle(sideA, sideB, sideC);
        assertFalse(result);
    }
}