package micronapster.ClassesNapsterServer;

import java.net.*;
import java.io.*;
import micronapster.MyObject.User;

public class deleteSongs implements Serializable {
    
    public static void main(String args[]){
        System.out.println("micronapster.ClassesNapsterServer.deleteSongs.main()");
        ServerSocket serverSocket;
        Socket socket;
        ObjectOutputStream output;
        ObjectInputStream input;
        int port = 9599;
        String host = "localhost";
        ServerDB serverDB = new ServerDB();
        
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting a connection");
            while(true){
                socket = serverSocket.accept();
                System.out.println("New user connected");
                System.out.println("Getting I/O");
                output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());
                serverDB.sessionClose((String)input.readObject());
                System.out.println("An user have closed session");
            }
            
        } catch (IOException e) {
            System.err.println("micronapster.ClassesNapsterServer.deleteSongs.main() IOExceotion ");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("micronapster.ClassesNapsterServer.deleteSongs.main() Exception");
            e.printStackTrace();
        }
        
    }
    
}
