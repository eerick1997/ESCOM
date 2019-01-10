
import java.io.*;
import java.net.*;

/**
 * Server using Datagram Sockets*
 */
public class Server {

    public static void main(String[] args) {
        final int server_port = 5678, client_port = 1234, size_packet = 65000;
        try {
             DatagramSocket datagramServer = new DatagramSocket(server_port);
             
            //forever
            for (;;) {
                /**----------------------------- Here the server receive a message ---------------------------------**/
                System.out.println("Server started... waiting for a message");
                DatagramPacket datagramPacket = new DatagramPacket(new byte[size_packet], size_packet);
                datagramServer.receive(datagramPacket);
                String msj_received = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("The client with " + datagramPacket.getAddress() + ":" + datagramPacket.getPort() + " direction says: " + msj_received);
                /**----------------------------- Here the server send a message ---------------------------------**/
                datagramServer.send(datagramPacket);
                if(msj_received.toUpperCase().equals("SALIR"))
                   System.exit(0);
            }

        } catch (Exception e) {
            System.err.println("An error has occurred in Server class" + e);
        }
    }
}
