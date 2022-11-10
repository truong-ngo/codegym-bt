package behavioral_design_pattern.strategy_exercise;

public class Main {
    public static void main(String[] args) {
        User truong = new User("Truong","123456");
        User thuy = new User("Thuy","654321");
        UserController userController = new UserController(new XMLStorage());
        userController.store(truong);
        userController.setStorage(new SQLStorage());
        userController.store(thuy);
    }
}
