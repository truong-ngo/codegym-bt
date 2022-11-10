package behavioral_design_pattern.strategy_exercise;

public class UserController {
    UserStorage storage;

    public UserController(UserStorage storage) {
        this.storage = storage;
    }

    public void setStorage(UserStorage storage) {
        this.storage = storage;
    }

    public void store(User user) {
        storage.store(user);
    }
}
