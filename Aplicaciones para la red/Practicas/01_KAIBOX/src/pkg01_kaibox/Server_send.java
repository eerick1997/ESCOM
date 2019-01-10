package pkg01_kaibox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

public class Server_send implements Runnable {

    private Socket socket;
    private Thread thread;

    public Server_send(Socket socket) {
        System.out.println("pkg01_kaibox.Server_send.<init>()");
        this.socket = socket;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("pkg01_kaibox.Server_send.run()");
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null, dataInputForFile = null;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            String path_file = dataInputStream.readUTF();
            System.out.println("File path " + path_file);
            long size = dataInputStream.readLong();
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputForFile = new DataInputStream(new FileInputStream(path_file));
            int n = 0;
            byte[] bytes = new byte[1500];
            long received = 0;

            while ((n = dataInputForFile.read(bytes)) > 0) {
                dataOutputStream.write(bytes, 0, n);
                received += n;
                dataOutputStream.flush();
                System.out.println("\r" + ((received * 100) / size) + "% received " + received + " total size " + size + "bytes readed " + n + "bytes");
            }
            System.out.println("Sent");
            dataInputStream.close();
            dataOutputStream.close();
            dataInputForFile.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("An error has occurred in Server_send class :C");
            e.printStackTrace();
        }
    }
}
