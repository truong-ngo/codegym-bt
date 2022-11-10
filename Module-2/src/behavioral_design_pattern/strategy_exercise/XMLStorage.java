package behavioral_design_pattern.strategy_exercise;

public class XMLStorage implements UserStorage {
    @Override
    public void store(User user) {
        System.out.println(user.toString() + " store to XML file");
    }
}
