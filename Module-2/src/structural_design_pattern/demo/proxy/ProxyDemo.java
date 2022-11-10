package structural_design_pattern.demo.proxy;

import java.util.Scanner;

public class ProxyDemo {
    public static void main(String[] args) {
        SocketInterface socket = new SocketProxy( "127.0.0.1", 8080, args[0].equals("first") ? true : false);
        String string;
        boolean skip = true;
        while (true) {
            if (args[0].equals("second") && skip) {
                skip = !skip;
            } else {
                string = socket.readLine();
                System.out.println("Receive - " + string);
                if (string.equals(null)) {
                    break;
                }
            }
            System.out.print( "Send ---- " );
            string = new Scanner(System.in).nextLine();
            socket.writeLine(string);
            if (string.equals("quit")) {
                break;
            }
        }
        socket.dispose();
    }
}
