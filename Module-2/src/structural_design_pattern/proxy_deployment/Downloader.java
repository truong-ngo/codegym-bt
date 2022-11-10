package structural_design_pattern.proxy_deployment;

import java.net.URL;

public interface Downloader {
    void download(URL url, String path);
}
