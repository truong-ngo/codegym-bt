package structural_design_pattern.proxy_deployment;

public class FileDownloaderProxy {
    private FileDownloader fileDownloader;

    public FileDownloaderProxy() {
        fileDownloader = new FileDownloader();
    }

    public void download() {

    }
}
