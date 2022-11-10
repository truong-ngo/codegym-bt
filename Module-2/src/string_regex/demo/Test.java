package string_regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String number = "+84966677798";
        String regex = "((\\+84)|0)[35789][0-9]{8}";
        String rex = "\\d";
        Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher("1");
        System.out.println(m.matches());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        System.out.println(matcher.matches());
    }
}
