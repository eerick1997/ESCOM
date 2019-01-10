import java.io.*;
import java.net.*;
import java.util.Scanner;

/**Client using Datagrama Sockets**/
public class Client {
    
    public static void main(String[] args){
        final int client_port = 1234, size_packet = 65000, server_port = 5678;
        try{
            InetAddress address = InetAddress.getByName("localhost");
            DatagramSocket datagramSocket = new DatagramSocket();
            System.out.println("Client stated...");
            //forever
            for(;;){
                /**----------------------------- Here a client send a message ---------------------------------**/
                //Client write a line
                Scanner scanner = new Scanner(System.in);
                String msj = scanner.nextLine(); //<- Here is our message ready to be send
                byte[] bytes_msj = msj.getBytes();
                System.out.println("Size bytes_msj: " + bytes_msj + " size " + bytes_msj.length + " bytes");
                //We create a datagram packet with a size of 65,000 bytes
                DatagramPacket datagramPacket = new DatagramPacket(bytes_msj, bytes_msj.length, address, server_port);
                datagramSocket.send(datagramPacket);
                /**---------------------------- Here a client receive a message --------------------------------**/
                datagramSocket.receive(datagramPacket);
                String msj_received = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("echo: " + msj_received);
                if(msj_received.toUpperCase().equals("SALIR"))
                    System.exit(0);
            }
            
        } catch(Exception e){
            System.err.println("An error has occurred in Client class: " + e);
        }
    }
}
