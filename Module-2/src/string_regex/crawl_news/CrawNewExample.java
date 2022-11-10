package string_regex.crawl_news;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawNewExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern pattern = Pattern.compile("article-title\">(.*?)</a>");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                String str = matcher.group(1).replaceAll("<(.*?)>","");
                String s = str.replace("&quot;", "");
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
