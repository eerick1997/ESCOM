package micronapster.ClassesNapsterServer;

import java.net.*;
import java.io.*;
import micronapster.MyObject.User;

public class getUserInfo implements Serializable {

    public static void main(String args[]) {
        System.out.println("micronapster.ClassesNapsterServer.getUserInfo.main() STARTS!!!");
        ServerSocket serverSocket;
        Socket socket;
        ObjectInputStream input;
        ObjectOutputStream output;
        int port = 5550;
        Boolean state = false;
        ServerDB serverDB;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting a connection...");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("User connected...");
                input = new ObjectInputStream(socket.getInputStream());
                output = new ObjectOutputStream(socket.getOutputStream());
                serverDB = new ServerDB();
                User user = (User)input.readObject();
                state = serverDB.verifyUser(user);
                
                serverDB.UpdateIPAddress(user, (((socket.getLocalAddress().toString()).replace((char)47, ' ')).replaceAll("\\s+", "")));
                
                output.writeObject(state);
                socket.close();
                System.out.println("Closing connection...");
            }
        } catch (IOException e) {
            System.err.println("IOException in class getUserInfo.java");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception in class getUserInfo.java");
            e.printStackTrace();
        }
    }

}
