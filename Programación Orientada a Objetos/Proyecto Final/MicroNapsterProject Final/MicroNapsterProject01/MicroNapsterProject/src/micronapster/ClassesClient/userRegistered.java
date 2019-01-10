package micronapster.ClassesClient;

import java.net.*;
import java.io.*;
import micronapster.MyObject.User;

public class userRegistered implements Serializable , Runnable{

    private Socket socket;
    private User user;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private static final String host = "localhost";
    private static final int port = 5550;
    Boolean bool;
    private Thread thread;

    public userRegistered(User user) {
        System.out.println("userRegistered constructor starts!");
        this.user = user;
        try {
            System.out.println("Creating socket...");
            socket = new Socket(host, port);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            System.err.println("userRegistered IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("userRegisteres Exception");
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try{
            System.out.println("userRegistered.java, run method starts!");
            output.writeObject(user);
            System.out.println("Server says: " + input.readObject());
            System.out.println("Closing socket");
            socket.close();
        } catch(Exception e){
            System.err.println("userRegistered.java, run method Exception e");
        }
    }
}
