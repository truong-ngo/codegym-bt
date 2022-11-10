package string_regex.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExample {
    private static Pattern pattern;
    private static final String PHONE_NUMBER_REGEX = "^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$";

    public PhoneNumberExample() {
        pattern = Pattern.compile(PHONE_NUMBER_REGEX);
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
