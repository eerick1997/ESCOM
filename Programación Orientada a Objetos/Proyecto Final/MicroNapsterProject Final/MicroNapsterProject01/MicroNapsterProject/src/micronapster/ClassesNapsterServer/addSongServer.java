    package micronapster.ClassesNapsterServer;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import micronapster.MyObject.Song;

public class addSongServer {
    public static void main(String argas[]){
        System.out.println("addSongServer.java, Starts!!!");
        ServerSocket serverSocket;
        Socket socket;
        ObjectOutputStream output;
        ObjectInputStream input;
        String host = "localhost";
        int port = 7000;
        
        try{
            System.out.println("Wainting for a connection...");
            serverSocket = new ServerSocket(port);
            while(true){
                socket = serverSocket.accept();
                System.out.println("Client connected...");
                System.out.println("Getting I/O...");
                output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());
                System.out.println("I/O Got successfully");
                new ServerDB().addSong((ArrayList<Song>)input.readObject());
                socket.close();
                System.out.println("Connection closed");
            }
        } catch (IOException e) {
            System.err.println("AddSongServer.java IOException...");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("AddSongServer.java Exception...");
            e.printStackTrace();
        }
        
    }
}
