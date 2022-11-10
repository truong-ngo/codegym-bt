package structural_design_pattern.demo.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketProxy implements SocketInterface {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SocketProxy(String host, int port, boolean wait) {
        try {
            if (wait) {
                ServerSocket server = new ServerSocket(port);
                socket = server.accept();
            } else {
                socket = new Socket(host, port);
            }
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public String readLine() {
        String string = null;
        try {
            string = in.readLine();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return string;
    }

    @Override
    public void writeLine(String string) {
        out.println(string);
    }

    @Override
    public void dispose() {
        try {
            socket.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
