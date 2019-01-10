package micronapster.ClassesClient;

import java.io.*;
import java.net.*;
import micronapster.MyObject.User;

public class closeSession implements Serializable, Runnable{
    
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Thread thread;
    private Socket socket;
    private String user;
    private static final int port = 9599;
    private static final String host = "localhost";
            
    public closeSession(String user){
        System.out.println("micronapster.ClassesClient.closeSession.<init>() STARTS!!!");
        this.user = user;
        try{
            System.out.println("Creating a new Socket");
            socket = new Socket(host, port);
            System.out.println("Creating a new Thread Object");
            thread = new Thread(this);
            System.out.println("Getting I/O");
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            System.out.println("Starting our thread");
            thread.start();
            
        } catch (IOException e) {
            System.err.println("micronapster.ClassesClient.closeSession.<init>() IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("micronapster.ClassesClient.closeSession.<init>() Exception");
            e.printStackTrace();
        }
    }
    
    public void run(){
        System.out.println("micronapster.ClassesClient.closeSession.run()");
        try{
            output.writeObject(user);
            socket.close();
        } catch (IOException e){
            System.err.println("micronapster.ClassesClient.closeSession.run() IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("micronapster.ClassesClient.closeSession.run() Exception");
            e.printStackTrace();
        }
    }
}
