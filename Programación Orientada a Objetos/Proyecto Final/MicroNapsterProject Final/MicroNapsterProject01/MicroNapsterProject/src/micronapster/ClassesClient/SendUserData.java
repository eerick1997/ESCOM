package micronapster.ClassesClient;

import java.net.*;
import java.io.*;
import micronapster.MyObject.User;

public class SendUserData implements Runnable, Serializable{
    
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private static final String host = "localhost";
    private static int port = 5501;
    private Thread thread;
    private User user;
    
    public SendUserData(User user){
        this.user = user;
        try{
            System.out.println("SendUserData constructor, creating a socket...");
            
            thread = new Thread(this);
            
            socket = new Socket(host, port);
            output = new ObjectOutputStream(socket.getOutputStream());
            //output.writeObject(user);
            input = new ObjectInputStream(socket.getInputStream());
            
            thread.start();
            System.out.println("Socket created successfully!");
        } catch (IOException e){
            System.err.println("Client.java, Client constructor IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Client.java, Client constructor Exception");
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        System.out.println("run method Starts!...");
        try{
            output.writeObject(user);
        } catch (Exception e) {
            System.out.println("Client.java, run method Exception");
            e.printStackTrace();
        }
    }
    
}
