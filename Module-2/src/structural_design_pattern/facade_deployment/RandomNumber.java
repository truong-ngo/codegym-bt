package structural_design_pattern.facade_deployment;

public class RandomNumber {
    public int generateRandomInteger(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
