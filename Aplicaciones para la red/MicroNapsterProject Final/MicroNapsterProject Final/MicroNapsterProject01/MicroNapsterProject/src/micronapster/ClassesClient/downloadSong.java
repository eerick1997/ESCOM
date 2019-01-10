package micronapster.ClassesClient;

import java.net.*;
import java.io.*;
import micronapster.MyObject.Song;

public class downloadSong implements Runnable, Serializable {

    private Socket socket, socketDownload;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Thread thread;
    private String host = "localhost", ipaddress;
    private Song song;
    private int port = 8500,
            otherPort = 6543;

    private FileOutputStream fileOutput;
    private DataInputStream dataInput;

    public downloadSong(Song song) {
        System.out.println("downloadSongs");
        this.song = song;
        try {
            System.out.println("Creating thread...");
            thread = new Thread(this);
            System.out.println("Creating socket...");
            socket = new Socket(host, port);
            System.out.println("Creating I/O");
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            System.out.println("Thread ready");
            thread.start();
        } catch (IOException e) {
            System.err.println("downloadSong.java IOException in contructor");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("downloadSong.java Exception in constructor");
            e.printStackTrace();
        }
    }

    public void downloadingSong(String newHost) {
        System.out.println("downloadSong.java, downloadingSong method Starts!");
        System.out.println("I'll connect to " + newHost);
        try {
            socketDownload = new Socket(newHost, otherPort);

            output = new ObjectOutputStream(socketDownload.getOutputStream());
            output.writeObject(song);
            
            InputStream in = socketDownload.getInputStream();
            System.out.println("microServer.java user connected");
            
            FileOutputStream out = new FileOutputStream(song.getName() + ".mp3");
            byte[] bytes = new byte[16 * 1024];

            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
            //output.close();
            out.close();
            output.close();
            System.out.println("Done!");
        } catch (IOException e) {
            System.err.println("downloadSong.java, downloadingSong method IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("downloadSong.java, downloadingSong method");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("downloadSong.java, run method starts!!!");
        try {
            output.writeObject(song.getUser());
            ipaddress = (String) input.readObject();
            System.out.println("The ip adress is: " + ipaddress);
            socket.close();
            downloadingSong(ipaddress);
        } catch (IOException e) {
            System.err.println("downloadSong run method IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("downloadSong run method Exception");
            e.printStackTrace();
        }
    }

}
