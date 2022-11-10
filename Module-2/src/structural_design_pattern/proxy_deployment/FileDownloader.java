package structural_design_pattern.proxy_deployment;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class FileDownloader implements Downloader {


    @Override
    public void download(URL url, String path) {
        ArrayList<String> strings = new ArrayList<>();
        String line;
        try {
            File file = new File(path);
            URLConnection urlConnection = url.openConnection();
            InputStream input = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            bufferedReader.close();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : strings) {
                bufferedWriter.write(string);
            }
            bufferedWriter.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
