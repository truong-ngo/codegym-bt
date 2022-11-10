package string_regex.validate_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    private static Pattern pattern;
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public AccountExample() {
        pattern = Pattern.compile(ACCOUNT_REGEX);
    }

    public boolean validateAccount(String account) {
        Matcher matcher = pattern.matcher(account);
        return matcher.matches();
    }
}
