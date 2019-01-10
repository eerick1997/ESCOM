package micronapster.ClassesNapsterServer;

import java.net.*;
import java.io.*;
import micronapster.MyObject.User;

public class addClientServer implements Serializable{
    
    public static void main (String args[]){
        System.out.println("addClientServer main method Starts!!!");
        ServerSocket serverSocket;
        Socket socket;
        ObjectInputStream input;
        ObjectOutputStream output;
        int port = 5501;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("AddClientServer: Waiting for a connection...");
            while(true) {
                socket = serverSocket.accept();
                System.out.println("AddClientServer: Client connected");
                input = new ObjectInputStream(socket.getInputStream());
                output = new ObjectOutputStream(socket.getOutputStream());
                User newUser = (User)input.readObject();
                newUser.setIpAddress(((socket.getLocalAddress().toString()).replace((char)47, ' ')).replaceAll("\\s+", ""));
                new ServerDB().addUser(newUser);
                output.writeObject("Server says: New user added!");
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("run method, addClientServer class, IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("run method, addClientServer class, Exception");
            e.printStackTrace();
        }
    }
}
