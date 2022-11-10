package string_regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        String text1 = "Hello java regex 2-12-2018, hello world 12/12/2018";
        Pattern pattern = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");
        Matcher matcher = pattern.matcher(text1);
        System.out.println("Date in string text1: " + text1);
        while (matcher.find()) {
            System.out.println(text1.substring(matcher.start(), matcher.end()));
        }

        String text2 = "a 2/12/2018";
        String text3 = "12/12/abed";
        pattern = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$");
        System.out.println("\nString " + text2 + " has pattern: "
                            + pattern.matcher(text2).matches());
        System.out.println("String " + text3 + " has pattern: "
                            + pattern.matcher(text3).matches());
        System.out.println("Java Javelin Jav".replaceAll("v\\w*", "wi"));
        String str = "Welcome   to gp-coder hover";
        String regex = ".*r$";
        Pattern pattern2 = Pattern.compile(regex);
        Matcher matcher2 = pattern2.matcher(str);
        boolean match = matcher2.matches();
        System.out.println("Match = " + match);
    }
}
