package Sockets;

import Objects.Person;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        //Constants
        final int port = 2345;
        //Probably we catch an exception
        try {
            //We create a ServerSocket with the port 2345
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started...");
            System.out.println("Waiting clients...");
            //forever
            for (;;) {
                //Client connected
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getInetAddress() + ":" + socket.getPort());
                //Creating IO stream Objects
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                //We read an object type Person
                Person person = (Person) objectInputStream.readObject();
                System.out.println("Object person contains \n\t->Name: " + person.getName() + "\n\t->Email: " + person.getEmail()
                        + "\n\t->Address: " + person.getAddress() + "\n\t->Age: " + person.getAge() + " years"
                        + "\n\t->Date: " + person.getDate());
                objectInputStream.close();
                objectOutputStream.close();
                socket.close();
            }
        } catch (Exception e) {
            System.err.println("An error has occurred in the clase Server: " + e);
        }
    }
}
