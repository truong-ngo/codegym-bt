package string_regex.validate_class_name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameExample {
    private static Pattern pattern;

    private static final String CLASS_NAME_REGEX = "^[CAP][0-9]{4}[GHIKLM]$";

    public ClassNameExample() {
        pattern = Pattern.compile(CLASS_NAME_REGEX);
    }

    public boolean validateClassName(String className) {
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();
    }
}
