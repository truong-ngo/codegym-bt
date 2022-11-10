package binary_file_serialization.demo;

public class FileOutputStream {
    public static void main(String[] args) throws Exception {
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream("src/binary_file_serialization/demo/code-gym-output.txt");
        byte[] bytes = new byte[] { 'C', 'o', 'd', 'e', 'G', 'y', 'm' };
        for (byte b : bytes) {
            fileOutputStream.write(b);
        }
        fileOutputStream.close();
    }
}
