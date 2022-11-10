package structural_design_pattern.proxy_deployment;

import java.io.IOException;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws IOException {
        String source = "https://www.oracle.com/";
        URL url = new URL(source);
        String path = "src/structural_design_pattern/proxy_deployment/file.html";
        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.download(url, path);
    }
}
