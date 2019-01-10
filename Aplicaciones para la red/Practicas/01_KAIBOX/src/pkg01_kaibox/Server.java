package pkg01_kaibox;

import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) {

        String path = "C:\\Users\\Erick\\Documents\\ESCOM\\Aplicaciones para la red\\Practicas\\01_KAIBOX\\KaiBox";
        int port = 5533;
        try {

            File folder = new File(path);
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Service started... waiting clients");

            if (!folder.exists()) {
                folder.mkdir();
            }

            for (;;) {
                Socket socket = serverSocket.accept();
                if (socket.isConnected()) {
                    new Server_receive(socket);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
