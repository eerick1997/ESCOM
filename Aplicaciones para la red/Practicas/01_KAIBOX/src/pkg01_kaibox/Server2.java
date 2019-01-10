package pkg01_kaibox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) {
        String path = "C:\\Users\\Erick\\Documents\\ESCOM\\Aplicaciones para la red\\Practicas\\01_KAIBOX\\KaiBox";
        int port = 5534;
        try {
            File folder = new File(path);
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Services started... waiting clients");
            if (!folder.exists()) {
                folder.mkdir();
            }

            for (;;) {
                Socket socket = serverSocket.accept();
                /**Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                //We get the path of the file
                String path_file = dataInputStream.readUTF();

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                dataInputStream = new DataInputStream(new FileInputStream(path_file));

                int n = 0;
                long received = 0;
                byte[] bytes = new byte[1500];
                while ((n = dataInputStream.read(bytes)) > 0) {
                    dataOutputStream.write(bytes, 0, n);
                    dataOutputStream.flush();
                    received += n;
                    System.out.println("Readed " + n + " received " + received);
                }
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();**/
                if(socket.isConnected()){
                new Server_send(socket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
