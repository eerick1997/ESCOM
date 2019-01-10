package micronapster.MicroServerClient;

import java.net.*;
import java.io.*;
import micronapster.ClassesClient.preferencesClient;
import micronapster.MyObject.Song;

public class microServer implements Serializable {

    public static void main(String args[]) {
        ServerSocket serverSocket;
        Socket socket;
        ObjectInputStream input;
        ObjectOutputStream output;
        DataOutputStream dataOutput = null;
        FileInputStream fileInput = null;
        Song song;
        int port = 6543;

        System.out.println("microServer.java main method Starts!!!");
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("microServer.java Waiting a connection");
            while (true) {
                socket = serverSocket.accept();
                input = new ObjectInputStream(socket.getInputStream());
                song = (Song)input.readObject();
                File file = new File(new preferencesClient().getPath(song.getUser()) + "/" + song.getName());
                long len = file.length();
                byte[] bytes = new byte[16 * 1024];
                InputStream in = new FileInputStream(file);
                OutputStream out = socket.getOutputStream();
                int count;
                while ((count = in.read(bytes)) > 0) {
                    out.write(bytes, 0, count);
                }
                socket.close();
                input.close();
                System.out.println("Done!");
            }
        } catch (IOException e) {
            System.err.println("microServer.java main method IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("microServer.java main method Exeption");
            e.printStackTrace();
        } finally {
            try {
                fileInput.close();
                dataOutput.close();
            } catch (Exception e) {
                System.err.println("microServer.java main method Exception (finally clause)");
                e.printStackTrace();
            }
        }

    }
}
