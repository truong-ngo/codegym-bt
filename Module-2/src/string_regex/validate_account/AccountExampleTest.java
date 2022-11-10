package string_regex.validate_account;

public class AccountExampleTest {
    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","constructor" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "seen" };

    public static void main(String[] args) {
        AccountExample accountExample = new AccountExample();
        for (String account : validAccount) {
            boolean isValid = accountExample.validateAccount(account);
            System.out.println("Account is " + account + " is valid " + isValid);
        }
        for (String account : invalidAccount) {
            boolean isValid = accountExample.validateAccount(account);
            System.out.println("Account is " + account + " is valid " + isValid);
        }
    }
}
