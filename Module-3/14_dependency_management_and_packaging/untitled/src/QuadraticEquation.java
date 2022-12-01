public class QuadraticEquation {
    public static void solveQuadraticEquation(float a, float b, float c) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Equation has no root");
            } else {
                System.out.println("Equation has one root: "
                        + "x = " + (-c / b));
            }
            return;
        }

        float delta = b*b - 4*a*c;
        float x1;
        float x2;

        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            System.out.println("Equation has two root: "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            System.out.println("Equation has double root: "
                    + "x1 = x2 = " + x1);
        } else {
            System.out.println("Equation has no root");
        }
    }
}
