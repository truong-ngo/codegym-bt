package structural_design_pattern.demo.proxy;

public interface SocketInterface {
    String readLine();
    void  writeLine(String string);
    void  dispose();
}
