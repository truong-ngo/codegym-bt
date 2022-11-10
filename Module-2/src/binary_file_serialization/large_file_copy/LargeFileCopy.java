package binary_file_serialization.large_file_copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class LargeFileCopy {
    public static void main(String[] args) {
        try {
            String input = "src/binary_file_serialization/large_file_copy/input.txt";
            File fileInput = new File(input);
            String output1 = "src/binary_file_serialization/large_file_copy/output1.txt";
            File fileOutput1 = new File(output1);
            String output2 = "src/binary_file_serialization/large_file_copy/output2.txt";
            File fileOutput2 = new File(output2);
            copyFileUsingJava7File(fileInput, fileOutput1);
            copyFileUsingStream(fileInput, fileOutput2);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void copyFileUsingJava7File(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFileUsingStream(File source, File destination) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(destination);
            byte[] chars = new byte[1024];
            int length;
            while ((length = fileInputStream.read(chars)) > 0) {
                fileOutputStream.write(chars, 0, length);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
