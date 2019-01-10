package micronapster.ClassesNapsterServer;

import java.io.*;
import java.net.*;
import micronapster.MyObject.Song;

public class getIPAddress implements Serializable{
    
    public static void main(String args[]){
        System.out.println("getIPAddress class main method STARTS!!!");
        ServerSocket serverSocket;
        Socket socket;
        ObjectInputStream input;
        ObjectOutputStream output;
        int port = 8500;
        
        try{
            serverSocket =  new ServerSocket(port);
            System.out.println("Waiting a connection...");
            while(true){
                socket = serverSocket.accept();
                System.out.println("User connected");
                System.out.println("Trying to get I/O...");
                output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());
                ServerDB db = new ServerDB();
                output.writeObject(db.getIPAddress((String)input.readObject()));
                socket.close();
            }
        } catch (IOException e){
            System.err.println("getIPAddress.java IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("getIPAddress.java Exception");
            e.printStackTrace();
        }
    }

}
