
package micronapster.ClassesClient;

import java.net.*;
import java.io.*;
import micronapster.MyObject.User;

public class userLogin implements Runnable, Serializable{
 
    private User user;
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private static final String host = "localhost";
    private static final int port = 6000;
    
    public userLogin(User user){
        this.user = user;
        try{
            System.out.println("userLogin constructor, creating a Socket...");
            socket = new Socket(host, port);
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Socket created successfully!!!");
        } catch (IOException e) {
            System.err.println("userLogin constructor, IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("userLogin constructor, Exception");
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        try{
            System.out.println("userLogin.java, run method starts!!!");
            input.readObject();
            
        } catch (IOException e) {
            System.err.println("userLogin.java, run method, IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("userLogin.java, run method, Exception");
            e.printStackTrace();
        }
    }
}
