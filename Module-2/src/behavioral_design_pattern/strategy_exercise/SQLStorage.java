package behavioral_design_pattern.strategy_exercise;

public class SQLStorage implements UserStorage {

    @Override
    public void store(User user) {
        System.out.println(user.toString() + " store to SQL file");
    }
}
