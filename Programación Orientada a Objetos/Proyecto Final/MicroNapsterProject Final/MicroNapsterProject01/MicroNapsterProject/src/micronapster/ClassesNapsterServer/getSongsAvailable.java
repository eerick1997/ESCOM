package micronapster.ClassesNapsterServer;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import micronapster.MyObject.Request;
import micronapster.MyObject.Song;

public class getSongsAvailable implements Serializable{

    public static void main(String args[]){
        System.out.println("getSongsAvailable main method Starts!!!");
        ObjectOutputStream output;
        ObjectInputStream input;
        ServerSocket serverSocket;
        Socket socket;
        int port = 9900;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for a connection...");
            while(true){
                socket = serverSocket.accept();
                System.out.println("User connected...");
                input = new ObjectInputStream(socket.getInputStream());
                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(new ServerDB().getSongs((Request)input.readObject()));
                socket.close();
            }
        } catch(IOException e){
            System.err.println("IOException in class getSongsAvailable.java");
            e.printStackTrace();
        } catch(Exception e){
            System.err.println("Exception in class getSongsAvailable.java");
            e.printStackTrace();
        }
    }
}
